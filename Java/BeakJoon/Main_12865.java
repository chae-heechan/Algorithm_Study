package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 골드 5
// 평범한 배낭
public class Main_12865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[][] dp;
    static int[][] things;

    public static void main(String[] args) throws IOException {
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = nk[0] + 1;
        K = nk[1] + 1;

        dp = new int[N][K];
        things = new int[N][2];     // 무게, 가치

        for (int i = 1; i < N; i++) {
            things[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 1; i <= N-1; i++) {
            for (int j = 1; j <= K-1; j++) {

                // i번째 물건을 담을 수 없을 경우
                if (things[i][0] > j) {
                    dp[i][j] = dp[i-1][j];  // 이전 가치 그대로 유지
                }
                else {
                    // 이전 가치와, 현재 물건이 들어갈 만큼의 물건 빼고 현재 물건을 추가한 가치
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-things[i][0]] + things[i][1]);
                }
            }
        }

        System.out.print(dp[N-1][K-1]);

    }


}
