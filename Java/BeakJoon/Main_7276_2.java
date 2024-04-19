package BeakJoon;

// 토마토 입력받고 1부터 4방탐색 하면서 익게두기
// 토마토는 큐에 추가하기 전에 자신이 며칠에 익는 토마토 인지 저장

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_7276_2 {
    public static void main(String[] args) throws IOException {
        int[] dr = {-1, 0, 1, 0};   // 상 우 하 좌
        int[] dc = {0, 1, 0, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[1];
        int m = nm[0];

        int[][] box = new int[n][m];
        Queue<Tomato> q = new LinkedList<>();

        int zeroCount = 0;
        int maxDay = 0;

        // 토마토 입력 받기
        for (int i = 0; i < n; i++) {
            box[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 1) {
                    q.add(new Tomato(i, j, 0));
                }
                else if (box[i][j] == 0){
                    zeroCount++;
                }
            }
        }

        while (!q.isEmpty()) {
            Tomato tomato = q.poll();
            maxDay = Math.max(maxDay, tomato.day);

            for (int d = 0; d < 4; d++) {
                int nextX = tomato.x + dr[d];
                int nextY = tomato.y + dc[d];

                if (isPossibleToMove(nextX, nextY, n, m, box)) {
                    q.add(new Tomato(nextX, nextY, tomato.day + 1));
                    box[nextX][nextY] = 1;
                    zeroCount--;
                }
            }
        }
        if (zeroCount == 0) {
            System.out.println(maxDay);
        }
        else {
            System.out.println(-1);
        }

    }

    private static boolean isPossibleToMove(int x, int y, int n, int m, int[][] box) {
        if (x >= n || x < 0 || y >= m || y < 0 || box[x][y] == 1 || box[x][y] == -1) {
            return false;
        }
        return true;
    }

    static class Tomato {

        Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }

        int x;
        int y;
        int day;
    }
}

