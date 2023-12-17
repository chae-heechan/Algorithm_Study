package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14430 {
    static int n, m;
    static int[][] board;
    static int[][] sumBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];
        board = new int[n + 1][m + 1];
        sumBoard = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < m; j++) {
                board[i][j+1] = temp[j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sumBoard[i][j] = board[i][j] + Math.max(sumBoard[i-1][j], sumBoard[i][j-1]);
            }
        }

        System.out.println(sumBoard[n][m]);
    }
}
