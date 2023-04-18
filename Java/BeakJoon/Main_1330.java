package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (a[0] > a[1]) {
            System.out.print(">");
        } else if (a[0] < a[1]) {
            System.out.print("<");
        } else {
            System.out.print("==");
        }
    }
}
