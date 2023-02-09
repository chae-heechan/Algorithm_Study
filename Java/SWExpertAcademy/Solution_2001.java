package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int t = 1; t <= TC; t++) {
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int n = nm[0];
            int m = nm[1];
            int max = 0;

            int[][] arr = new int[n + 1][n + 1];
            int[][] sum = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i][0] = 0;
                System.arraycopy(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(), 0, arr[i], 1,n);
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + arr[i][j] - sum[i - 1][j - 1];
                }
            }

            for (int i = 1; i <= n - m + 1; i++) {
                for (int j = 1; j <= n - m + 1; j++) {
                    int fly = sum[i+m-1][j+m-1] - sum[i-1][j+m-1] - sum[i+m-1][j-1] + sum[i-1][j-1];
                    max = Math.max(max, fly);
                }

            }

            System.out.printf("#%d %d\n", t, max);
        }

    }
}
