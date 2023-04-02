package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 브론즈 5
// A+B - 4
public class Main_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            int[] ab = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(ab[0] + ab[1]);
        }
    }
}
