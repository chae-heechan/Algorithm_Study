package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 골드 5
// 토마토
public class Main_7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static Queue<Tomato> q = new LinkedList<>();
    static int n, m;
    static int count;
    static int zeroCount;

    static int[] dr = {0, 0, 1, -1};    // 우 좌 하 상
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = nm[1];
        m = nm[0];

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    q.offer(new Tomato(i, j));
                }else if (map[i][j] == 0) {
                    zeroCount++;
                }
            }
        }

        while (!q.isEmpty()) {
            // 사방 탐색 후 0 인 부분 1로 바꾸고 q에 offer
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Tomato data = q.poll();
                int r = data.r;
                int c = data.c;

                for (int d = 0; d < 4; d++) {
                    int nextR = r + dr[d];
                    int nextC = c + dc[d];

                    if (isPossible(nextR, nextC)) {
                        map[nextR][nextC] = 1;
                        q.offer(new Tomato(nextR, nextC));
                        zeroCount--;
                    }
                }
            }
            count++;
        }
        if (zeroCount != 0) count = 0;

        System.out.println(count-1);

    }

    // 맵 안쪽이고 0일 경우
    private static boolean isPossible(int r, int c) {
        if (r >= 0 && r < n && c >= 0 && c < m && map[r][c] == 0) {
            return true;
        }
        return false;
    }

}

class Tomato {
    int r;
    int c;

    public Tomato(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
