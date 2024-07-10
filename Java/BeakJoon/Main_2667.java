package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2667 {
    private static int n;
    private static int[][] board;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        List<Integer> towns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int townCount = 0;

        // 순환 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    towns.add(0);
                    towns.set(townCount++, bfs(i, j));
                }
            }
        }

        // 마을들 정렬
        Collections.sort(towns);

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(townCount).append("\n");
        for (int i = 0; i < townCount; i++) {
            sb.append(towns.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        int houseCount = 1;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(x, y));
        board[x][y] = 0;

        while(!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            int currentX = coordinate.x;
            int currentY = coordinate.y;

            for (int d = 0; d < 4; d++) {
                int nextX = currentX + dx[d];
                int nextY = currentY + dy[d];
                if (isPossibleToMove(nextX, nextY)) {
                    board[nextX][nextY] = 0;
                    queue.add(new Coordinate(nextX, nextY));
                    houseCount++;
                }
            }
        }

        return houseCount;
    }

    private static boolean isPossibleToMove(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || board[x][y] == 0) {
            return false;
        }
        return true;
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
