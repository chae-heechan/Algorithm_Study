package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1976 {

    private static int n, m;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

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

        int[] plans = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = plans[0];

        for (int i = 1; i < m; i++) {
            if (!equal(start, plans[i])) {
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");

    }

    // 두 그룹 합치기
    private static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a<b) parents[b] = a;
        else parents[a] = b;
    }

    // 최상위 부모 노드 찾기
    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean equal(int x, int y) {
        return find(x) == find(y);
    }
}
