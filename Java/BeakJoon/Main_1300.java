package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int sum = 0;    //이전 줄 까지 수 합
        int i, x;

        for(i = n, x = 1; i >=0; i--, x++) {
            if ((sum + (i * 2) - 1) > k) break;
            sum+= i * 2 - 1;

        }

        // 남은 줄은 x단
        // 시작점은 (x,x) 끝점은 (x,n)
        int start = x;
        int end = n;
        while (start == end) {
            int mid = (x + n) / 2;


        }


    }
}
