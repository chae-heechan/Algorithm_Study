package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 1000 - Integer.parseInt(br.readLine());
        int count = 0;
        int[] coins = {500, 100, 50, 10, 5, 1};

        for (int coin : coins) {
            count += n / coin;
            n = n % coin;
        }

        System.out.println(count);
    }
}
