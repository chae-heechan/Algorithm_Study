package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 조합
public class Solution_5607 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long[] factorial;
    static int n, r;

    public static void main(String[] args) throws IOException {

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            sb.append("#").append(t).append(" ");

            int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = nk[0];
            r = nk[1];
            factorial = new long[n + 1];
            factorial[0] = 1;

            sb.append(nCr(n, r, 1234567891)).append("\n");

        }

        System.out.println(sb);

    }

    private static long nCr(int n, int r, long p) {
        if (r == 0) {
            return 1L;
        }

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i % p;
        }

        return (factorial[n] * power(factorial[r], p - 2, p)
                % p * power(factorial[n - r], p - 2, p)
                % p) % p;
    }

    private static long power(long x, long y, long p) {
        long res = 1L;
        x = x % p;

        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}
