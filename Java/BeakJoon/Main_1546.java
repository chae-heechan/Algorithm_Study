package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 브론즈 1
// 평균
public class Main_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double m = 0;
        double sum = 0;

        int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int sc : scores) {

            if (m < sc)
                m = sc;
        }

        for(int i = 0; i < n; i++) {
            sum += scores[i] / m * 100;
        }

        System.out.print(sum/n);

    }
}
