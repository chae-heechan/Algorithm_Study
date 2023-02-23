package BeakJoon;
/*
    방문한 번호에 다시 방문하지 않게 주의하며 BFS
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 실버 1
// 숨바꼭질
public class Main_1697 {
    static int n, k;
    static Queue<Integer[]> q = new LinkedList<>();
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = nk[0];
        k = nk[1];

        int count = 0;

        bfs(n, count);
    }

    private static void bfs(int start, int count) {
        q.offer(new Integer[]{start, count});
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer[] data = q.poll();
            start = data[0];
            count = data[1];
            if (start == k) {
                System.out.println(count);
                return;
            }
            if (start + 1 <= 100000 && start + 1 >= 0 && !visited[start + 1]) {
                q.offer(new Integer[]{start + 1, count + 1});
                visited[start + 1] = true;
            }
            if (start - 1 <= 100000 && start - 1 >= 0 && !visited[start - 1]) {
                q.offer(new Integer[]{start - 1, count + 1});
                visited[start - 1] = true;
            }
            if (start * 2 <= 100000 && start * 2 >= 0 && !visited[start * 2]) {
                q.offer(new Integer[]{start * 2, count + 1});
                visited[start * 2] = true;
            }
        }


    }
}
