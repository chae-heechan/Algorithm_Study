package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// D5
// 최적 경로
public class Solution_1247 {
    static int n;
    static int[] start, end;
    static int[][] homes;
    static boolean[] visited;
    static int[] result;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            end = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            homes = new int[n+2][2];
            visited = new boolean[n+2];
            result = new int[n+2];

            homes[0] = start;
            homes[n+1] = end;
            for (int i = 1; i <= n; i++) {
                homes[i][0] = Integer.parseInt(st.nextToken());
                homes[i][1] = Integer.parseInt(st.nextToken());
            }

            permutation(1);

            sb.append("#").append(t).append(" ").append(minDistance).append("\n");
            minDistance = Integer.MAX_VALUE;
        }

        System.out.println(sb);
    }

    private static void permutation(int count) {

        // 집일 경우
        if (count == n+1)  {
            // 계산 후 최소값과 비교
            int sum = 0;
            for (int i = 0; i < n+1; i++) {
                // |x1 - x2| + |y1 - y2|
                sum += (Math.abs(homes[result[i]][0] - homes[result[i+1]][0]) + Math.abs(homes[result[i]][1] - homes[result[i+1]][1]));
            }

            if (minDistance > sum) {
                minDistance = sum;
            }
            return;
        }

        result[0] = 0;
        visited[0] = true;

        result[n+1] = n+1;
        visited[n+1] = true;

        for (int i = 1; i < n+1; i++) {
            if (visited[i] == true) continue;
            visited[i] = true;
            result[count] = i;
            permutation(count+1);
            visited[i] = false;
        }

    }
}
