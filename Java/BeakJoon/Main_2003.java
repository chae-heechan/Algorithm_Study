package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int right = 0;

        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= m) {
                sum -= inputs[left++];
            }
            else if (right == n) break;
            else {
                sum += inputs[right++];
            }

            if (sum == m) {
                count++;
            }
        }

        System.out.println(count);

    }
}
