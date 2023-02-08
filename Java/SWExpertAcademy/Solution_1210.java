package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// D4
// Ladder1
public class Solution_1210 {
    private static final int SIZE = 100;
    static int[][] escalera = new int[SIZE][SIZE];
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();// 테케 번호 날리기

            for (int i = 0; i < SIZE; i++) {
                escalera[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int x = SIZE - 1;
            int y = 0;
            int direccion = 2;  // 1: left, 2: up. 3: right;
            int[] dx = {0, 0, -1, 0};
            int[] dy = {0, -1, 0, 1};

            for (int i = 0; i < SIZE; i++) {
                if (escalera[SIZE - 1][i] == 2) {
                    y = i;
                    break;
                }
            }

            while (x > 0) {

                if (direccion == 1){
                    if (y != 0 && escalera[x][y - 1] == 1) { // 왼쪽에 사다리가 있을 경우
                        direccion = 1;
                    }else{
                        direccion = 2;
                    }
                }
                else if (direccion == 3){
                    if (y != SIZE - 1 && escalera[x][y + 1] == 1) { // 오른쪽에 사다리가 있을 경우
                        direccion = 3;
                    }else{
                        direccion = 2;

                    }
                }
                else if (direccion == 2) {
                    if (y != 0 && escalera[x][y - 1] == 1) { // 왼쪽에 사다리가 있을 경우
                        direccion = 1;
                    } else if (y != SIZE - 1 && escalera[x][y + 1] == 1) { // 오른쪽에 사다리가 있을 경우
                        direccion = 3;
                    }
                }
                x += dx[direccion];
                y += dy[direccion];
            }

            System.out.printf("#%d %d\n", tc, y);

        }
    }
}
