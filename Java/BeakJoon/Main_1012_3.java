package BeakJoon;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1012_3 {
    private static boolean[][] visited;
    private static int[][] field;
    private static int m, n, k, count;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            count = 0;
            int[] mnk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = mnk[0];
            m = mnk[1];
            k = mnk[2];

            field = new int[n][m];
            visited = new boolean[n][m];

            // 배추 심기
            for (int i = 0; i < k; i++) {
                int[] cabbage = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                field[cabbage[0]][cabbage[1]] = 1;
            }

            // 배추 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 배추일 경우
                    if (field[i][j] == 1 && visited[i][j] == false) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);


    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dr[d];
            int nextY = y + dc[d];
            if (isPossibleToMove(nextX, nextY)) {
                dfs(nextX, nextY);
            }
        }
    }

    private static boolean isPossibleToMove(int x, int y) {
        if (x >= n || x < 0 || y >= m || y < 0 || field[x][y] == 0 || visited[x][y] == true) {
            return false;
        }
        return true;
    }
}
