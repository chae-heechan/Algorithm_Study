package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 실버 2
// 부분수열의 합
public class Main_1182 {
    static int n, s;
    static int count = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ns = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = ns[0];
        s = ns[1];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0, 0);

        if (s == 0){
            count--;
        }

        System.out.println(count);

    }

    public static void dfs(int v, int sum) {
        if (v == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        dfs(v + 1, sum + arr[v]);
        dfs(v + 1, sum);
    }
}
