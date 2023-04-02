package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 실버 2
// 외판원 순회 2
public class Main_10971 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static boolean[] visited;
    static int n;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        String s = "1234";
        String a;
        a = s.substring(0, 1);
        char c = a.charAt(1);

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
            visited[i] = false;
        }

        if (minCost == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(minCost);
    }

    private static void dfs(int start, int prev, int count, int sum) {
        if (count == n - 1) {
            if (map[prev][start] == 0) {
                return;
            }
            minCost = Math.min(minCost, sum + map[prev][start]);
            return;
        }

        if (minCost <= count) return;

        for (int i = 0; i < n; i++) {
            if (visited[i] == false && map[prev][i] != 0) {
                visited[i] = true;
                dfs(start, i, count+1, sum + map[prev][i]);
                visited[i] = false;
            }
        }
    }
}
