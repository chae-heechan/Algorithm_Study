package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// D4
// 사칙연산 유효성 검사
public class Solution_1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());

            int answer = 1;

            for (int i = 0; i < n; i++) {

                String[] arr = br.readLine().split(" ");

                if (arr.length == 4) {  // 자식이 있을 경우
                    if (arr[1].charAt(0) >= '0' && '9' >= arr[1].charAt(0)) { // 숫자일 경우
                        answer = 0;
                    }
                }else if (arr.length == 2){ // 자식이 없을 경우
                    if (arr[1].charAt(0) < '0' || '9' < arr[1].charAt(0)) {  // 숫자가 아닐 경우
                        answer = 0;
                    }
                } else {
                    answer = 0;
                }

            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");

        }

        System.out.println(sb);
    }
}
