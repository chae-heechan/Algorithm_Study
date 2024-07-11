package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result1 = a + b - c;
        int result2 = Integer.parseInt(new StringBuilder().append(a).append(b).toString()) - c;

        System.out.println(result1);
        System.out.println(result2);
    }
}
