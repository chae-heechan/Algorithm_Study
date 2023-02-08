package BeakJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 실버 3
// 구간 합 구하기 4
public class Main_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = nm[0];
        int m = nm[1];

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sums = new int[n+1];

        for(int i = 1; i <= n; i++){
            sums[i] = sums[i-1] + arr[i-1];
        }

        for (int i = 0; i < m; i++) {
            int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(sums[ab[1]] - sums[ab[0]-1]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
