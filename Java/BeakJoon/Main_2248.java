package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 골드 3
// 이진수 찾기
public class Main_2248 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, L, I;

    public static void main(String[] args) throws IOException {
        int[] nli = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = nli[0];
        L = nli[1];
        I = nli[2];

        // 1부터 조합으로 nCr 개수 구해서 넘기전까지 더하고 하나씩 해보면서 i까지 찾기
        // 31까지 조합 미리 구해두기

        

    }
}
