package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxValue = 0;
        int maxIndex = 0;

        for (int i = 1; i < 10; i++) {
            int currentValue = Integer.parseInt(br.readLine());

            if (currentValue > maxValue) {
                maxValue = currentValue;
                maxIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(maxValue).append("\n").append(maxIndex);

        System.out.println(sb);
    }
}
