package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int R = Integer.valueOf(st.nextToken());

            String p = st.nextToken();

            for (int i = 0; i < p.length(); i++) {
                for (int r = 0; r < R; r++) {
                    sb.append(p.charAt(i));
                }
            }
            sb.append("\n");

        }

        System.out.println(sb);
    }
}
