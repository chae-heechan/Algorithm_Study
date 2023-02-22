package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5644 {
    static int[] dr = {0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};

    static int m, a;
    static Charger[] bcMap;
    static int[][] user1;
    static int[][] user2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {

            int[] ma = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            m = ma[0];
            a = ma[1];

            bcMap = new Charger[a];

            user1 = new int[m+1][2];
            user2 = new int[m+1][2];
            int[] user1Pos = {0, 0};
            int[] user2Pos = {9, 9};
            user1[0] = user1Pos.clone();
            user2[0] = user2Pos.clone();

            // 사용자 이동정보에 따라 인덱스 저장
            int index = 1;
            for (int dir : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
                user1Pos[0] += dr[dir];
                user1Pos[1] += dc[dir];
                user1[index++] = user1Pos.clone();
            }

            index = 1;
            for (int dir : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
                user2Pos[0] += dr[dir];
                user2Pos[1] += dc[dir];
                user2[index++] = user2Pos.clone();
            }

            for (int i = 0; i < a; i++) {
                int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                bcMap[i] = new Charger(info[0], info[1], info[2], info[3]);
            }

            List<Integer>[] user1ChargerMap = new ArrayList[m+1];
            for (int i =0; i < m+1; i++) {
                user1ChargerMap[i] = new ArrayList<>();
            }

            for (int i = 0; i < m+1; i++) {
                for (int j = 0; j < a; j++) {
                    if (Math.abs(user1[i][0] - bcMap[i].r) + Math.abs(user1[j][1] - bcMap[j].c) <= bcMap[j].dis)
                        user1ChargerMap[i].add(j);
                }
            }

            // 충전기와 맨해튼거리 구해 충전할 수 있는 충전기 저장
            // 만약 사용자 둘이 사용가능 한 충전기가 겹칠 경우 permutation

            // 정리된 충전기들 사용량 계산해 출력

        }
    }

}

class Charger {
    int r;
    int c;
    int dis;
    int point;

    public Charger(int r, int c, int dis, int point) {
        this.r = r;
        this.c = c;
        this.dis = dis;
        this.point = point;
    }
}
