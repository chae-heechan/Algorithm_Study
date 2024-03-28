package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String ps = br.readLine();

            boolean isYes = true;
            int pCount = 0;

            for (char p : ps.toCharArray()) {
                if (p == '(') {
                    pCount++;
                    continue;
                }

                if (pCount == 0) {
                    sb.append("NO\n");
                    isYes = false;
                    break;
                }

                pCount--;
            }

            if (pCount != 0) {
                sb.append("NO\n");
                continue;
            }

            if (isYes) {
                sb.append("YES\n");
            }

        }

        System.out.print(sb);
    }
}
