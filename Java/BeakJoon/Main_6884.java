package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_6884 {
    static boolean prime[] = new boolean[10000 * 10000+1];

    public static void main(String[] args) throws IOException {
        isPrime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            int minSize = 10000;
            int[] minSubSequence = null;

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] sequence = Arrays.copyOfRange(input, 1, input.length);

            // 인덱스부터 시작해 사이즈를 늘려가며 체크하기
            for(int i = 0; i < sequence.length-1; i++) {
                int sumOfSubSequence = sequence[i];
                for (int j = 1; j < sequence.length - i; j++) {
                    if (j >= minSize-1) break;
                    sumOfSubSequence += sequence[i+j];
                    if (!prime[sumOfSubSequence]) {
                        minSize = j+1;
                        minSubSequence = Arrays.copyOfRange(sequence, i, i+j+1);
                    }
                }
            }

            if(minSize == 10000) {
                System.out.println("This sequence is anti-primed. ");
            }else {
                System.out.printf("Shortest primed subsequence is length %d: ", minSize);
                for (int item : minSubSequence){
                    System.out.printf("%d ",item);
                }
            }

        }
    }

    public static void isPrime() {
        int n = 10000 * 10000;

        prime[0] = prime[1] = true;

        for (int i = 2; i*i <= n; i++) {
            // i가 소수일 경우
            if (!prime[i]) {
                // i의 배수 true
                for(int j = i*i; j <= n; j+=i) {
                    prime[j] = true;
                }
            }
        }
    }
}
