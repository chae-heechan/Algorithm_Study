package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] zeroToNine = new int[10];
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        char[] result = String.valueOf(A * B * C).toCharArray();

        for (char c : result) {
            int n = (int) c - '0';

            zeroToNine[n]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(zeroToNine[i]);
        }
    }
}
