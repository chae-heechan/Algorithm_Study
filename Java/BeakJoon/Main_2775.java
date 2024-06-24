package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] apartment = new int[15][15];
        for (int i = 0; i < 15; i++) {
            apartment[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            int sum = 0;
            for (int j = 0; j < 15; j++) {
                sum += apartment[i-1][j];
                apartment[i][j] = sum;
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(apartment[k][n]).append("\n");
        }

        System.out.println(sb);
    }
}
