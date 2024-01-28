package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0) continue;

                numberOfArea++;
                Queue<Point> q = new LinkedList<>();
                int currentNumber = picture[i][j];
                int currentSizeOfArea = 1;
                picture[i][j] = 0;
                q.add(new Point(i, j));


                while (!q.isEmpty()) {
                    Point point = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int nextX = point.x + dx[d];
                        int nextY = point.y + dy[d];
                        if (isPossibleToMove(nextX, nextY, m, n, picture, currentNumber)) {
                            q.add(new Point(nextX, nextY));
                            picture[nextX][nextY] = 0;
                            currentSizeOfArea++;
                        }

                    }
                }
                answer[1] = Math.max(answer[1], currentSizeOfArea);
            }
        }
        answer[0] = numberOfArea;
        return answer;
    }

    public boolean isPossibleToMove(int x, int y, int m, int n, int[][] picture, int currentNumber) {
        if (x < 0 || x >= m || y < 0 || y >= n || picture[x][y] != currentNumber) {
            return false;
        }

        return true;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
