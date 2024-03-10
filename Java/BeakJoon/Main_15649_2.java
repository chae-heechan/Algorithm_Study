package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15649_2 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        int[] arr = new int[m];
        boolean[] visited = new boolean[n];

        permutation(arr, visited, 0, n, m);

        System.out.print(sb);
    }

    public static void permutation(int[] arr, boolean[] visited, int now, int n, int m) {
        if (now == m) {
            for (int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[now] = i + 1;
                permutation(arr, visited, now+1, n, m);
                visited[i] = false;
            }
        }
    }
}
