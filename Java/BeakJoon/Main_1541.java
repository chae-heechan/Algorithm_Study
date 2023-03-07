package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 실버 2
// 잃어버린 괄호
public class Main_1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split("-");

        int answer = Arrays.stream(Arrays.stream(str[0].split("\\+")).mapToInt(Integer::parseInt).toArray()).sum();

        for (int i = 1; i < str.length; i++) {
            answer -= Arrays.stream(Arrays.stream(str[i].split("\\+")).mapToInt(Integer::parseInt).toArray()).sum();
        }

        System.out.println(answer);
    }
}
