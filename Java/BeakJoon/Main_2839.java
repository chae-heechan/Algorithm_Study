package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 실버 4
// 설탕 배달
public class Main_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 4 || n == 7){
            System.out.println(-1);
            return;
        }

        if ((n%5) == 1 || (n%5) == 3) {     // 나머지가 1, 3일 경우
            System.out.println(n/5 + 1);
        } else if ((n%5) == 2 || (n%5) == 4) {      // 나머지가 2, 4일 경우
            System.out.println(n/5 + 2);
        } else {    // 나머지가 0일 경우
            System.out.println(n/5);
        }

        // 3, 4,     5, 6, 7, 8, 9,     10, 11, 12, 13, 14,     15, 16, 17, 18, 19       봉지 개수
        // 3, 4,     0, 1, 2, 3, 4,      0,  1,  2,  3,  4,      0,  1,  2,  3,  4       N % 5
        // 1, -,     0, 2, -, 1, 3,      0,  2,  4,  1,  3,      0,  2,  4,  1,  3       3의 개수
        // 0, -,     1, 0, -, 1, 0,      2,  1,  0,  2,  1,      3,  2,  1,  3,  2       5의 개수
        //    0,                 1,                      2,                      3       N / 5
        // 0, -,     1, 2, -, 2, 3,      2,  3,  4,  3,  4,      3,  4,  5,  4,  5       총 개수
    }

}
