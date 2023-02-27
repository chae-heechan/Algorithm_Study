package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// D4
// 창용 마을 무리의 개수
public class Solution_7465 {
    static Set<Integer> pueblos;
    static int[] parents;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            sb.append("#").append(t).append(" ");
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            n = nm[0] + 1;
            m = nm[1];

            // makeSet
            parents = makeSet(n);
            pueblos = new HashSet<>();

            // union
            for (int i = 0; i < m; i++) {
                int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                union(data[0], data[1]);
            }

            for (int i = 0; i < n; i++) {
                findSet(i);
            }

            // 마을 개수 구하기
            for (int i = 0; i < n; i++) {
                pueblos.add(parents[i]);
            }

            sb.append(pueblos.size() - 1).append("\n");

        }
        System.out.println(sb);
    }

    private static int[] makeSet(int n) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        return parents;
    }

    private static void union(int x, int y) {
        if (findSet(x) == findSet(y)) return;
        parents[findSet(y)] = findSet(x);
    }

    private static int findSet(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findSet(parents[x]);
    }
}
