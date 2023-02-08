package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2798 {
    static int k;
    static int maxValue;
    static int max;
    static int[] n;
    static int m = 3;
    static int[] values = new int[m];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] kmax = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        k = kmax[0];
        maxValue = kmax[1];

        n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        combination(0, 0);

        System.out.println(max);
    }

    public static void combination(int now, int start){
        if (now == m){
            int sum = 0;
            for(int i = 0; i < m; i++){
                sum += values[i];
            }
            if (sum <= maxValue && max <sum){
                max = sum;
            }
            return;
        }
        for(int i = start; i < k; i++){
            values[now] = n[i];
            combination(now+1, i+1);
        }
    }
}
