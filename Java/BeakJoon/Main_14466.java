package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 골드 4
// 소가 길을 건너간 이유 6
public class Main_14466 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k, R;
    static int[][] map;
    static int count;
    static int[] dr = {0, 1, 0, -1};    // 우 하 좌 상
    static int[] dc = {1, 0, -1, 0};
    static List<Integer>[] road;    // 차원압축으로 길 넣어두기
    static int cows[];
    static int answer;

    public static void main(String[] args) throws IOException {
        int[] nkr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nkr[0];
        k = nkr[1];
        R = nkr[2];

        cows = new int[n*n+1];
        map = new int[n][n];
        road = new ArrayList[n*n+1];

        for (int i = 0; i < n*n+1; i++) {
            road[i] = new ArrayList<>();
        }

        // 길 추가
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            int xp = Integer.parseInt(st.nextToken())-1;
            int yp = Integer.parseInt(st.nextToken())-1;

            road[x*n + y].add(xp*n + yp);
            road[xp*n + yp].add(x*n + y);
        }

        // 구역 나누기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }

        // 소 구역 체크
        for (int i = 0; i < k; i++) {
            int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            findCow(rc[0]-1, rc[1]-1);
        }
        // 계산
        for (int i = 0; i < n*n+1; i++) {
            answer += cows[i] * (k - cows[i]);
        }

        System.out.println(answer/2);
    }

    private static void findCow(int r, int c) {
        cows[map[r][c]]++;
    }

    private static void dfs(int r, int c) {
        map[r][c] = count;

        for (int d = 0; d < 4; d++) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];

            // 길이면 continue
            if (road[r*n + c].contains(nextR*n + nextC)) {
                continue;
            }

            if (isPossible(nextR, nextC)){
                dfs(nextR, nextC);
            }
        }
    }

    private static boolean isPossible(int r, int c) {
        if (r >= 0 && r < n && c >= 0 && c < n && map[r][c] == 0){
            return true;
        }
        return false;
    }

}
