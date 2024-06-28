package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260_2 {

    private static int n, m, v;
    private static boolean[] visited;
    private static List<Integer>[] board;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        board = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            board[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int firstPoint = Integer.parseInt(st.nextToken());
            int secondPoint = Integer.parseInt(st.nextToken());

            board[firstPoint].add(secondPoint);
            board[secondPoint].add(firstPoint);
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(board[i]);
        }

        visited = new boolean[n+1];
        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(sb);
    }

    private static void dfs(int v) {
        visited[v] = true;

        sb.append(v).append(" ");

        for (int next : board[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }

    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for (int next : board[current]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }

        }
    }
}
