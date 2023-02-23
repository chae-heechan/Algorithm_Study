package BeakJoon;
/*
    1. 맵을 입력받고 크기에 맞는 visted 배열을 생성한다.
    2. 28개의 이미 방문한 알파벳을 저장할 수 있는 배열을 생성한다.
    3. dfs를 돌며 탐색하고 maxCount를 저장한다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 골드 4
// 알파벳
public class Main_1987 {
    static char[][] map;
    static boolean[][] visited;
    static boolean[] alphabets = new boolean[28];
    static int R, C;
    static int maxCount;

    static int[] dr = {0, 0, 1, -1};    // 우 좌 하 상
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        R = rc[0];
        C = rc[1];

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 0);

        System.out.println(maxCount);
    }

    private static void dfs(int x, int y, int count) {
        if (alphabets[(int)map[x][y] - 65] || visited[x][y]) { // 해당 알파벳이 이미 있거나, 이미 방문했을 경우
            if (maxCount < count) maxCount = count;
            return;
        }

        visited[x][y] = true;
        alphabets[(int)map[x][y] - 65] = true;
        count++;


        for (int i = 0; i < 4; i++) {
            int nextX = x + dr[i];
            int nextY = y + dc[i];
            if (isPossibleToMove(nextX, nextY)) {
                dfs(nextX, nextY, count);
                visited[nextX][nextY] = false;
            }
        }
        alphabets[(int)map[x][y] - 65] = false;
    }

    private static boolean isPossibleToMove(int x, int y) {
        if (x >= 0 && x < R && y >= 0 && y < C) return true;
        return false;
    }
}
