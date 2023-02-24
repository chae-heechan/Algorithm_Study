package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 골드 5
// 적록색약
public class Main_10026 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int n;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][n];

        int count = 0;

        // 일반인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        sb.append(count).append(" ");
        count = 0;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'R') map[i][j] = 'G';
            }
        }

        // 적록색약
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        sb.append(count);

        System.out.println(sb);

    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if (isPossibleToMove(nextR, nextC) && map[r][c] == map[nextR][nextC]) {
                dfs(nextR, nextC);

            }
        }
    }

    private static boolean isPossibleToMove(int r, int c) {
        if (r >= 0 && r < n && c >= 0 && c < n && !visited[r][c])
            return true;
        return false;
    }
}
