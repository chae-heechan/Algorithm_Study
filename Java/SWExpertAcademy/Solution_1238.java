package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// D4
// Contact
public class Solution_1238 {
    static final int SIZE = 101;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> q;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            sb.append("#").append(t).append(" ");
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int l = data[0];
            int s = data[1];

            graph = new int[SIZE][SIZE];
            q = new LinkedList<>();
            visited = new boolean[SIZE];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < l/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from][to] = 1;
            }

            bfs(s);
        }
        System.out.println(sb);
    }

    // 큐에 넣고 큐 사이즈 체크하고 그만큼돌고 다음 깊이
    private static void bfs(int x) {
        q.offer(x);
        visited[x] = true;
        int max = 0;
        int last = 0;

        while(!q.isEmpty()) {
            int queueSize = q.size();
            max = 0;

            for (int i = 0; i < queueSize; i++) {
                int cur = q.poll();

                for (int j = 0; j < SIZE; j++) {
                    if (graph[cur][j] == 1 && visited[j] == false) {  // 해당 길이 있고 방문하지 않았을 경우
                        q.offer(j);
                        visited[j] = true;
                        max = Math.max(j, max);
                    }
                }
            }
            if (max != 0) last = max;
        }
        sb.append(last).append("\n");
    }
}
