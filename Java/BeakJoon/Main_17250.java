package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17250 {

    private static int n, m;
    private static int[] parents, planets;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];  // 은하 수
        m = nm[1];  // 철도 수

        parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }

        // 행성 수 입력
        planets = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            planets[i] = Integer.parseInt(br.readLine());
        }

        // 철도 연결
        for (int i = 0; i < m; i++) {
            int[] railRoad = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            union(railRoad[0], railRoad[1]);
        }

        System.out.print(sb);

    }

    private static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a==b) {
            sb.append(planets[a]).append("\n");
        }
        else if (a < b) {
            parents[b] = a;
            planets[a] += planets[b];
            sb.append(planets[a]).append("\n");
        }
        else {
            parents[a] = b;
            planets[b] += planets[a];
            sb.append(planets[b]).append("\n");
        }
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}
