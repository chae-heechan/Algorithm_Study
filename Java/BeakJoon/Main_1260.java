package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 실버 2
// DFS와 BFS
public class Main_1260 {
    static int[][] points;
    static boolean[] visited;
    static int n, m, v;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int[] nmv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = nmv[0];
        m = nmv[1];
        v = nmv[2];

        points = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            points[p1][p2] = points[p2][p1] = 1;
        }


        dfs(v);
        sb.append("\n");

        visited = new boolean[n+1];
        bfs(v);

        System.out.println(sb);

    }

    private static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");

        for (int i = 0; i < n+1; i++) {
            if (points[start][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start){
        q.offer(start);     // 큐에 추가
        visited[start] = true;  // 방문 체크

        while (!q.isEmpty()) {  // 큐가 비어있지 않을 때 까지
            start = q.poll();   // poll
            sb.append(start).append(" ");
            for (int i = 0; i <= n; i++) {   // 나로부터 다른 갈곳 체크
                if (points[start][i] == 1 && visited[i] == false) { // 간선이 있고 가보지 않았다면
                    q.offer(i); // 큐에 추가
                    visited[i] = true;  // 방문체크
                }
            }
        }
    }

}
