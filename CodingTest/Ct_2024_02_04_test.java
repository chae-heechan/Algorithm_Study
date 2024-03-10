import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ct_2024_02_04_test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int maxNumber = n * n;

        int[][] board = new int[n][n];

        // 우 하 좌 상
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int xPosition = 0;
        int yPosition = 0;
        int direction = 0;

        for (int i = 1; i <= maxNumber; i++) {
            board[xPosition][yPosition] = i;

            // 이동 불가할 경우 -> 이동 방향 변경
            if (!isPossibleToMove(xPosition + dx[direction], yPosition + dy[direction], n, board)) {
                direction++;
                if (direction == 4) {
                    direction = 0;
                }
            }
            // 이동
            xPosition += dx[direction];
            yPosition += dy[direction];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isPossibleToMove(int x, int y, int n, int[][] board) {
        if (x < 0 || x >= n || y < 0 || y >= n || board[x][y] != 0) {
            return false;
        }

        return true;
    }
}
