package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int M = Integer.parseInt(br.readLine());
        long[] B = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(A);


        for (long b : B) {
            int maxIndex = N - 1;
            int minIndex = 0;
            int criteriaIndex = maxIndex / 2;

            while(true) {
                if (b == A[criteriaIndex]) {
                    sb.append(1).append("\n");
                    break;
                }
                else if (b > A[criteriaIndex]) {    // b가 더 클 경우
                    minIndex = criteriaIndex + 1;
                } else if (b < A[criteriaIndex]) {  // b가 더 작을 경우
                    maxIndex = criteriaIndex - 1;
                }
                criteriaIndex = (maxIndex + minIndex) / 2;

                if (maxIndex - minIndex <= 1) {
                    if (b == A[maxIndex] || b == A[minIndex]) {
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;
                }
            }
        }

        System.out.println(sb);

    }
}
