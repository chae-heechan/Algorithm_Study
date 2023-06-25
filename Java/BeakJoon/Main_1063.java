package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1063 {
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static int direction = 0;

    static int[] kingLocation = new int[2];
    static int[] stoneLocation = new int[2];
    static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        kingLocation[0] = input[0].charAt(0);
        kingLocation[1] = input[0].charAt(1) - 48;
        stoneLocation[0] = input[1].charAt(0);
        stoneLocation[1] = input[1].charAt(1) - 48;
        n = Integer.parseInt(input[2]);

        for (int i = 0; i < n; i++) {
            String comm = br.readLine();
            
            if (comm.equals("R")) {
                direction = 0;
            } else if (comm.equals("L")) {
                direction = 1;
            } else if (comm.equals("B")) {
                direction = 2;
            }else if (comm.equals("T")) {
                direction = 3;
            } else if (comm.equals("RT")) {
                direction = 4;
            } else if (comm.equals("LT")) {
                direction = 5;
            } else if (comm.equals("RB")) {
                direction = 6;
            } else {
                direction = 7;
            }

            int nextkx = kingLocation[0] + dx[direction];
            int nextky = kingLocation[1] + dy[direction];
            int nextsx = stoneLocation[0] + dx[direction];
            int nextsy = stoneLocation[1] + dy[direction];

            if (isPossibleToMove(nextkx, nextky)) {
                if (nextkx == stoneLocation[0] && nextky == stoneLocation[1]) {
                    if (isPossibleToMove(nextsx, nextsy)) {
                        stoneLocation[0] = nextsx;
                        stoneLocation[1] = nextsy;
                        kingLocation[0] = nextkx;
                        kingLocation[1] = nextky;
                    }
                } else {
                    kingLocation[0] += dx[direction];
                    kingLocation[1] += dy[direction];
                }
            }

        }

        System.out.printf("%c%d\n%c%d", (char)kingLocation[0], kingLocation[1], (char)stoneLocation[0], stoneLocation[1]);
    }

    public static boolean isPossibleToMove(int x, int y) {
        if (x >= 65 && x < 73 && y >= 1 && y < 9) {

            return true;
        }
        return false;
    }
}
