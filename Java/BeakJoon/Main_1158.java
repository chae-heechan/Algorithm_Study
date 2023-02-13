package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 실버 4
// 요세푸스 문제
public class Main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] checked = new int[n];
        int[] answer = new int[n];

        int count = 0;

        for (int i = 0, index = 0, j = 0; i < n; i++){
            while (true) {

                if (checked[j] == 0) {
                    count++;
                    if (count == k) {
                        checked[j] = 1;
                        answer[index++] = j+1;
                        count = 0;
                        j++;
                        if (j == n) j = 0;
                        break;
                    }
                }
                j++;
                if (j == n) j = 0;
            }

        }

        sb.append("<");

        for (int i = 0; i < n-1; i++){
            sb.append(answer[i]).append(", ");
        }

        sb.append(answer[n-1]).append(">");

        System.out.println(sb);

    }
}