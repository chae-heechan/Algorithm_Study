package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 실버 1
// 배열 돌리기 1
public class Main_16926 {
    static int[][] arr;
    static int n;
    static int m;
    static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] nmr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = nmr[0];
        m = nmr[1];
        r = nmr[2];

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int x = 0;
        while (n - (x*2) >= 2 && m - (x*2) >= 2) {
            rotate(x++);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void rotate(int x) {
        for (int c = 0; c < r; c++) {
            int temp = arr[x][x];

            // 상
            for (int i = x + 1; i <= m - 1 - x; i++) {
                arr[x][i - 1] = arr[x][i];
            }
            // 우
            for (int i = x + 1; i <= n - 1 - x; i++) {
                arr[i - 1][m - 1 - x] = arr[i][m - 1 - x];
            }
            // 하
            for (int i = m - 1 - x - 1; i >= x; i--) {
                arr[n - 1 - x][i + 1] = arr[n - 1 - x][i];
            }
            // 좌
            for (int i = n - 1 - x - 1; i >= x; i--) {
                arr[i + 1][x] = arr[i][x];
            }

            arr[x+1][x] = temp;
        }
    }

}
