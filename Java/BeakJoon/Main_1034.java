package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_1034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        int[][] board = new int[n][m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int zeroCount = 0;

            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    zeroCount++;
                }
            }

            // zeroCount가 k보다 크고 k와 홀짝이 맞을 경우
            if (zeroCount <= k && zeroCount % 2 == k % 2) {
                int count = 0;

                for (int j = i; j < n; j++) {
                    if (Arrays.equals(board[i], board[j])) {
                        count++;
                    }
                }

                answer = Math.max(answer, count);
            }
        }

        System.out.println(answer);
    }
}
