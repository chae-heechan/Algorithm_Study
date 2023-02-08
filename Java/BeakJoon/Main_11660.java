package BeakJoon;
import java.io.*;
import java.util.Arrays;

public class Main_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = nm[0];
        int m = nm[1];
        int[][] arr = new int[n+1][n+1];
        int[][] sums = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            arr[i][0] = 0;
            System.arraycopy(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(), 0, arr[i], 1, n);

            for(int j = 1; j <= n; j++){
                sums[i][j] = arr[i][j] + sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1];
            }
        }

        for (int i = 0; i < m; i++) {
            int[] points = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int r = points[0];
            int c = points[1];
            int x = points[2];
            int y = points[3];

            sb.append(sums[x][y] - sums[r-1][y] - sums[x][c-1] + sums[r-1][c-1]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
