package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2151 {

    static int n;
    static int answer = 2500;

    static int startDoorR = 0;
    static int startDoorC = 0;
    static int endDoorR = 0;
    static int endDoorC = 0;

    static int[] dr = {-1, 0, 1, 0};   // 상 우 하 좌
    static int[] dc = {0, 1, 0, -1};

    static char[][] board;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        visited = new boolean[n][n][4];

        for (int i = 0; i < n; i++) {
            char[] newLine = br.readLine().toCharArray();
            board[i] = newLine;

            // 문 위치 저장
            for (int j = 0; j < n; j++) {
                char character = newLine[j];
                if (character == '#') {
                    if (startDoorR == 0 && startDoorC == 0) {
                        startDoorR = i;
                        startDoorC = j;
                    } else {
                        endDoorR = i;
                        endDoorC = j;
                    }
                }
            }
        }

        Queue<Position> q = new LinkedList<>();

        // 처음 위치 큐에 넣기
        for (int d = 0; d < 4; d++) {
            int nextR = startDoorR + dr[d];
            int nextC = startDoorC + dc[d];
            if (isPossibleToMove(nextR, nextC, d)) {
                q.add(new Position(nextR, nextC, d, 0));
                visited[nextR][nextC][d] = true;
            }
        }

        while (!q.isEmpty()) {
            for (int d = 0; d < 4; d++) {
                visited[endDoorR][endDoorC][d] = false;
            }

            Position position = q.poll();
//            System.out.printf("(%d, %d, %d, %d)\n", position.r, position.c, position.d, position.count);

            if (position.r == endDoorR && position.c == endDoorC) {
//                System.out.println("found end door");
                answer = Math.min(answer, position.count);
                continue;
            }

            // 거울일 경우
            if (board[position.r][position.c] == '!') {
                for (int d = 0; d < 4; d++) {
                    int nextR = position.r + dr[d];
                    int nextC = position.c + dc[d];
                    if (isPossibleToMove(nextR, nextC, d)) {
                        if (d == position.d) {  // 진행 방향일 경우
                            visited[nextR][nextC][d] = true;
                            q.add(new Position(nextR, nextC, d, position.count));   // 거울 카운트 그대로
                        } else {    // 진행 방향이 아닐 경우
//                            System.out.println(d);
                            if (d == (position.d + 2) %4) {
                                continue;
                            }
//                            System.out.printf("direction (%d, %d)\n", nextR, nextC);
                            visited[nextR][nextC][d] = true;
                            q.add(new Position(nextR, nextC, d, position.count + 1));   // 거울 카운트 + 1
                        }

                    }
                }
            } else {    // 거울이 아닐 경우
                int nextR = position.r + dr[position.d];
                int nextC = position.c + dc[position.d];
                if (isPossibleToMove(nextR, nextC, position.d)) {
                    q.add(new Position(nextR, nextC, position.d, position.count));
                    visited[nextR][nextC][position.d] = true;
                }
            }

        }

        System.out.println(answer);

    }

    public static boolean isPossibleToMove(int r, int c, int d) {
        if (r < n && c < n && r >= 0 && c >= 0 && board[r][c] != '*' && !visited[r][c][d]) {
            return true;
        }
        return false;
    }
}

class Position {
    int r;  // row
    int c;  // column
    int d;  // direction
    int count;

    public Position(int r, int c, int d, int count) {
        this.r = r;
        this.c = c;
        this.d = d;
        this.count = count;
    }
}
