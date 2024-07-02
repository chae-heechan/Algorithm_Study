package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652 {

    private static int[] output;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        output = new int[m];

        permutation(0, 1, n, m);

        System.out.println(sb);

    }

    private static void permutation(int now, int start, int n, int m) {
        if (now == m) {
            print(m);
            return;
        }

        for (int i = start; i < n + 1; i++) {
            output[now] = i;
            permutation(now + 1, i, n, m);
        }
    }

    private static void print(int m) {
        for (int i = 0; i < m; i++) {
            sb.append(output[i]).append(" ");
        }
        sb.append("\n");
    }
}
