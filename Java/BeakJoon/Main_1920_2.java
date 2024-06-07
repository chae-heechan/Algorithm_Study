package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1920_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[] a = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int m = Integer.parseInt(br.readLine());
        long[] b = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(a);

        for (int i = 0; i < m; i++) {

            if (Arrays.binarySearch(a, b[i]) >= 0) {
                sb.append(1).append("\n");
            }
            else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
