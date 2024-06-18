package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long minIndex = 0;
        long maxIndex = 0;

        int[] lines = new int[k];

        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            maxIndex = Math.max(maxIndex, lines[i]);
        }
        maxIndex++;

        long midIndex = 0;

        while (minIndex < maxIndex) {
            int count = 0;
            midIndex = (maxIndex + minIndex) / 2;

            for (int i = 0; i < lines.length; i++) {
                count += (lines[i] / midIndex);
            }

            if (count < n) {    // 더 많은 랜선이 필요한 경우
                maxIndex = midIndex;
            }
            else {    // 더 적은 랜선이 필요한 경우
                minIndex = midIndex + 1;
            }
        }

        System.out.println(minIndex - 1);
    }
}
