package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1976_2 {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parents = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parents[i] = i;
        }

        for (int i = 1; i < n+1; i++) {
            String[] cities = br.readLine().split(" ");

            for (int j = 1; j < n+1; j++) {
                if (cities[j-1].equals("1")) {
                    union(i, j);
                }
            }
        }

        int[] plan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int parent = find(plan[0]);

        for (int i = 1; i < m; i++) {
            if (parent != find(plan[i])) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a < b)
            parents[b] = a;
        else
            parents[a] = b;
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }
}
