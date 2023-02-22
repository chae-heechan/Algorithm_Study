package SWExpertAcademy;/*
    1. 맵을 입력 받고 탱크를 찾으면 위치와 방향을 저장한다.(맵에서 탱크의 위치에는 .으로 저장한다.)
    2. 입력받은 명령어를 반복하며 map의 limit check를 하며 수행한다.
    3. 수행이 끝난 후 맵에 탱크 위치에 맞게 탱크를 넣어주고 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// D3
// 상호의 배틀필드
public class Solution_1873 {
    static int h;
    static int w;
    static char[][] map;
    static int tankR;
    static int tankC;
    static int tankDir;
    static char[] commands;

    static int[] dr = {0, 0, -1, 1};   // 좌, 우, 상, 하
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            int[] hw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            h = hw[0];
            w = hw[1];

            map = new char[h][w];

            // 입력으로 맵 생성 및 탱크 위치와 방향 저장
            for (int i = 0; i < h; i++) {
                char[] chs = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    map[i][j] = chs[j];

                    switch (map[i][j]) {
                        case '<':
                            tankR = i;
                            tankC = j;
                            tankDir = 0;
                            map[i][j] = '.';
                            break;
                        case '>':
                            tankR = i;
                            tankC = j;
                            tankDir = 1;
                            map[i][j] = '.';
                            break;
                        case '^':
                            tankR = i;
                            tankC = j;
                            tankDir = 2;
                            map[i][j] = '.';
                            break;
                        case 'v':
                            tankR = i;
                            tankC = j;
                            tankDir = 3;
                            map[i][j] = '.';
                            break;
                    }
                }
            }

            int n = Integer.parseInt(br.readLine());
            commands = br.readLine().toCharArray();

            int nextTankR;
            int nextTankC;

            for (char command : commands) {
                switch (command) {
                    case 'L':
                        moveTank(0);
                        break;
                    case 'R':
                        moveTank(1);
                        break;
                    case 'U':
                        moveTank(2);
                        break;
                    case 'D':
                        moveTank(3);
                        break;
                    case 'S':
                        shot();
                        break;

                }
            }

            if (tankDir == 0) {
                map[tankR][tankC] = '<';
            } else if (tankDir == 1) {
                map[tankR][tankC] = '>';
            } else if (tankDir == 2) {
                map[tankR][tankC] = '^';
            } else if (tankDir == 3) {
                map[tankR][tankC] = 'v';
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }

    // 맵 밖이 아닐 경우 이동 가능
    private static boolean isPossibleToMove(int r, int c) {
        if (r >= 0 && r < h && c >= 0 && c < w) {
            return true;
        }
        return false;
    }

    // 탱크 움직이기
    private static void moveTank(int dir) {
        int nextTankR = tankR + dr[dir];
        int nextTankC = tankC + dc[dir];
        tankDir = dir;

        // 맵 안쪽이고 평지일 경우 이동
        if (isPossibleToMove(nextTankR, nextTankC) && map[nextTankR][nextTankC] == '.') {
            tankR = nextTankR;
            tankC = nextTankC;
        }
    }

    // 발사하기
    private static void shot() {
        int nextR = tankR;
        int nextC = tankC;

        while (true) {
            nextR += dr[tankDir];
            nextC += dc[tankDir];

            if (!isPossibleToMove(nextR, nextC)) {  // map 밖으로 벗어날 경우
                break;
            }

            if (map[nextR][nextC] == '*') {     // 벽돌 벽일 경우
                map[nextR][nextC] = '.';
                break;
            } else if (map[nextR][nextC] == '#') {  // 강철 벽일 경우
                break;
            }
        }

    }

}
