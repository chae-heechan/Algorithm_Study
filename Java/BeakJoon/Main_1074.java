package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 실버 1
// Z
public class Main_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nrc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = nrc[0];
        int r = nrc[1];
        int c = nrc[2];

        int start = 0;
        int end = (int) Math.pow((int) Math.pow(2, n), 2) - 1;
        int half = (start + end) / 2;

        int rStart = 0;
        int rEnd = (int) Math.pow(2, n)-1;
        int rHalf = (rStart + rEnd) / 2;

        int cStart = 0;
        int cEnd = (int) Math.pow(2, n)-1;
        int cHalf = (cStart + cEnd) / 2;

        while (start < end) {
            if (rHalf >= r) {    // r이 반보다 작을 경우
                rEnd = rHalf;
                rHalf = (rStart + rEnd) / 2;

                if (cHalf >= c) {    // c가 반보다 작을 경우    2사분면
                    cEnd = cHalf;
                    cHalf = (cStart + cEnd) / 2;

                    end = (half + start)/2;

                }else {     // 1사분면
                    cStart = cHalf+1;
                    cHalf = (cStart + cEnd) / 2;

                    end = half;
                    start = (start + half) / 2 + 1;
                }

            }else {     // r이 반보다 클 경우
                rStart = rHalf+1;
                rHalf = (rStart + rEnd) / 2;

                if (cHalf >= c) {    // c가 반보다 작을 경우     3사분면
                    cEnd = cHalf;
                    cHalf = (cStart + cEnd) / 2;

                    start = half + 1;
                    end = (start + end) / 2;
                }else {
                    cStart = cHalf+1;
                    cHalf = (cStart + cEnd) / 2;

                    start = ((half + 1) + end) / 2 + 1;
                }

            }

            half = (start + end) / 2;

        }


        System.out.println(half);

    }
}
