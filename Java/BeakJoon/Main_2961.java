package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 실버 2
// 도영이가 만든 맛있는 음식
public class Main_2961 {
    static int n;
    static long min;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        min = Long.MAX_VALUE;

        dfs(0, 1, 0);

        System.out.println(min);
    }

    public static void dfs(int v, int mul, int add){
        if (v == n){
            if(add != 0 && min > Math.abs(mul - add)){
                min = Math.abs(mul - add);
            }
            return;
        }

        dfs(v+1, mul * arr[v][0], add + arr[v][1]);
        dfs(v+1, mul, add);
    }
}
