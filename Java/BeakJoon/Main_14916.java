package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }

        int five = n/5;
        n = n%5;
        int two = n / 2 ;
        n = n%2;

        if (n == 1) {
            System.out.println(five + two + 2);
        } else {
            System.out.println(five + two);
        }
    }
}
