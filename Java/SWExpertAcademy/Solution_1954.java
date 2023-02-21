package SWExpertAcademy;

import java.util.Scanner;

// D2
// 달팽이 숫자
public class Solution_1954 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int TC = sc.nextInt();

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int direction;

        int r;
        int c;

        int[][] arr;

        for (int t = 1; t <= TC; t++) {
            r = 0;
            c = 0;
            direction = 0;
            int n = sc.nextInt();
            sb.delete(0,n);
            arr = new int[n][n];

            for (int num = 1; num <= n * n; num++) {
                arr[r][c] = num;

                if (direction == 0 && direction == 2) { // 옆으로 움직일 경우
                    int nextR = r + dr[direction];
                    if (nextR < 0 || nextR >= n || arr[nextR][c] != 0) {
                        direction++;
                    }
                } else {    // 위아래로 움직일 경우
                    int nextC = c + dc[direction];
                    if (nextC < 0 || nextC >= n || arr[r][nextC] != 0) {
                        direction++;
                        if (direction == 4) {
                            direction = 0;
                        }
                    }
                }

                r += dr[direction];
                c += dc[direction];


            }

            System.out.printf("#%d \n", t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++){
                    sb.append(arr[i][j]+ " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);

        }

    }
}
