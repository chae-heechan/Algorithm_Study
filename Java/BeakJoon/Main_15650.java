package BeakJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// N과 M (2) 실버3
public class Main_15650 {
    static int[] path;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = nm[0];
        int m = nm[1];
        path = new int[m];


        combination(1, 1, n, m);
        System.out.println(sb);
    }
    // n개의 수를 m개 뽑기

    public static void combination(int now,int start, int n, int m){
        if (now > m){
            for (int i = 0; i <m; i++){
                sb.append(path[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= n; i++){
            path[now-1] = i;
            combination(now+1,i+1, n, m);
        }


    }
}
