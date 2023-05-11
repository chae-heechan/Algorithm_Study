package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1132 {
    public static void main(String[] args) throws IOException {
        Long answer = 0l;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = new HashMap<>();
        List<Character> ban = new ArrayList<>();
        int[][] alphabet = new int[12][10];
        long[] scores = new long[10];

        int n = Integer.parseInt(br.readLine());

        String[] strs = new String[n];

        for (int i  = 0; i < n; i++) {
            String str = br.readLine();
            strs[i] = str;
            ban.add(str.charAt(0));
            int startIndex = 12 - str.length();
            for (int j = 0; j < str.length(); j++) {
                alphabet[startIndex+j][((int)str.charAt(j) - 65)]++;
            }
        }

//        // 0의 자릿수
//        for (int j = 0; j < 10; j++) {
//            scores[j] += alphabet[11][j];
//        }

        double k = 0.1;
        // 1부터 12까지
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 10; j++){
                scores[j] += k * alphabet[i][j];
            }
            k *= 10;
        }

        PriorityQueue<Alpha> pq = new PriorityQueue<>();

        for (int i = 0; i < 10; i++) {
            pq.add(new Alpha(i, scores[i]));
        }

        List<Alpha> al = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            al.add(pq.poll());
        }

        for (int i = 0; i < 10; i++) {
            if (ban.contains(al.get(i).alphabet))
                continue;
            else {
                map.put(al.get(i).alphabet, 0);
                al.remove(i);
                break;
            }
        }

        int number = 1;
        for (int i = 0; i < 9; i++) {
            map.put(al.get(i).alphabet, number++);
        }


        for (int i = 0; i < n; i++) {
            String str = strs[i];
            StringBuilder newStr = new StringBuilder();

            for (int j = 0; j < str.length(); j++) {
                newStr.append(map.get(str.charAt(j)));
            }
            answer += Long.parseLong(newStr.toString());

        }

        System.out.println(answer);
    }
}

class Alpha implements Comparable<Alpha>{
    char alphabet;
    long value;

    @Override
    public int compareTo(Alpha o) {
        return (int)(this.value - o.value);
    }

    Alpha(int i, long score) {
        this.alphabet = (char)(i+65);
        this.value = score;
    }
}
