package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_21940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        // 거리 초기화
        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int[] abd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = abd[0];
            int b = abd[1];
            int d = abd[2];
            if (dist[a][b] > d) {
                dist[a][b] = d;
            }
        }

        int k = Integer.parseInt(br.readLine());
        int[] cities = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 플로이드 와샬
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][l] + dist[l][j]);
                }
            }
        }

        int[] max = new int[n+1];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < cities.length; j++) {
                max[i] = Math.max(max[i], dist[cities[j]][i] + dist[i][cities[j]]);
            }
            min = Math.min(min, max[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (min >= max[i]) {
                result.add(i);
            }
        }
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            sb.append(r).append(" ");
        }

        System.out.print(sb);
    }


}
