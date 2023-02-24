package BeakJoon;
/*
    1. 문자를 입력받고 사전 순으로 정렬해서 저장
    2. 조합으로 자음 2개이상, 모음 1개이상 총 길이 l인 암호만 String으로 저장 후 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 골드 5
// 암호 만들기
public class Main_1759 {
    static int l, c;
    static List<Character> alphabets = new ArrayList<>();
    static boolean[] visited;
    static char[] password;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int[] lc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        l = lc[0];
        c = lc[1];

        visited = new boolean[c];
        password = new char[l];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alphabets.add(st.nextToken().charAt(0));
        }

        alphabets.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });

        combination(0, 0, l);

        System.out.print(sb);


    }

    private static void combination(int start, int count, int r) {
        if (count == r) {

            int consonantCount = 0; // 자음 카운트
            int vowelCount = 0;     // 모음 카운트

            for (int i = 0; i < alphabets.size(); i++) {
                if (visited[i]) {

                    char a = alphabets.get(i);

                    if (a == 'a' || a == 'e'|| a == 'i' || a == 'o' || a == 'u') vowelCount++;
                    else consonantCount++;

                    password[r - (count--)] = (alphabets.get(i));
                }
            }
            if (consonantCount >= 2 && vowelCount >= 1) {
                for (int i = 0; i < l; i++) {
                    sb.append(password[i]);
                }
                sb.append("\n");
            }
            password = new char[l];
            return ;
        }

        for (int i = start; i < alphabets.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i+1, count+1, r);
                visited[i] = false;
            }
        }


    }

}
