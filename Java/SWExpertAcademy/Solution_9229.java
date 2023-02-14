package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// D3
// 한빈이와 Spot Mart
public class Solution_9229 {
    static int n;
    static int m;
    static int[] snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            sb.append("#").append(t).append(" ");

            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            n = nm[0];
            m = nm[1];

            snacks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            sb.append(permutation(n)).append("\n");
        }

        System.out.println(sb);

    }

    private static int permutation(int n) {
        int max = -1;
        int sum;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sum =  snacks[i] + snacks[j];

                if (sum > max && sum <= m) {    //최대값 보다 크고, m보다 같거나 작을 경우
                    max = sum;
                    if (sum == m){      // 같을 경우 최대값 출력
                        return m;
                    }
                }
            }
        }
        return max;
    }
}
