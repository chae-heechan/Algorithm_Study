package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1012_2 {
    static boolean[][] visited;
    static boolean[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int count = 0;
            int[] mnk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = mnk[0];
            n = mnk[1];
            int k = mnk[2];

            visited = new boolean[m][n];
            board = new boolean[m][n];

            for (int i = 0; i < k; i++) {
                int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                board[xy[0]][xy[1]] = true;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == true && visited[i][j] == false) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nextx = x+dx[d];
            int nexty = y+dy[d];
            if (nextx >= 0 && nextx < m && nexty >= 0 && nexty < n) {
                if (board[nextx][nexty] == true && visited[nextx][nexty] == false) {
                    dfs(nextx, nexty);
                }
            }
        }
    }
}
