package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_12785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] wh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int w = wh[0];
        int h = wh[1];
        int x = xy[0];
        int y = xy[1];

        long[][] dp = new long[w][h];

        for (int i = 0; i < w; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < h; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < w; i++) {
            for (int j = 1; j < h; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] % 1000007;

            }
        }

        System.out.println((dp[x-1][y-1] * dp[w-x][h-y]) % 1000007);

    }
}
