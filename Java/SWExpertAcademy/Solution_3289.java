package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// D4
// 서로소 집합
public class Solution_3289 {
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
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < m; i++) {
                int[] operation = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                // union
                if (operation[0] == 0) {
                    union(operation[1], operation[2]);
                }

                // findSet
                if (operation[0] == 1) {
                    if (findSet(operation[1]) == findSet(operation[2]))
                        sb.append(1);
                    else sb.append(0);
                }
            }
            sb.append("\n");

        }

        System.out.println(sb);

    }

    private static void union(int x, int y) {
        if (findSet(x) == findSet(y)) return;
        parents[findSet(y)] = findSet(x);
    }

    private static int findSet(int x){
        if (x == parents[x]) return x;
        return parents[x] = findSet(parents[x]);
    }
}
