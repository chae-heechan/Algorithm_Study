package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14916_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        if (n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }

        count += n / 5;
        n = n % 5;

        if (n % 2 == 0) {
            count += n / 2;
            System.out.println(count);
            return;
        }

        count--;
        n += 5;

        count += n / 2;
        System.out.println(count);

    }
}
