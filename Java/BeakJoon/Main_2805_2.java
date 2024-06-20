package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long left = 0;
        long right = 0;

        for (int i = 0; i < trees.length; i++) {
            right = Math.max(trees[i], right);
        }

        long mid = (left + right) / 2;

        while (left <= right) {
            long count = 0;

            for (int i = 0; i < trees.length; i++) {
                long cut = trees[i] - mid;

                if (cut > 0) {
                    count += cut;
                }
            }

            if (count >= m) {
                left = mid + 1;
            }
            else if (count < m) {
                right = mid - 1;
            }

            mid = (left + right) / 2;
        }

        System.out.println(mid);


    }
}
