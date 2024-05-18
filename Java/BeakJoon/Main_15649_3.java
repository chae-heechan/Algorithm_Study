package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_3 {
    private static StringBuilder sb = new StringBuilder();
    private static int n, m;
    private static int[] input, numbers;
    private static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 마지막 수
        m = Integer.parseInt(st.nextToken());   // 수열의 길이

        input = new int[n];
        numbers = new int[m];
        isSelected = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            input[i] = i+1;
        }

//        combination(0, 0);
        permutation(0);

        System.out.println(sb);
    }

    private static void combination(int count, int start) {
        if (count == m) {
            for (int i = 0; i < numbers.length; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            numbers[count] = input[i];
            combination(count+1, start+1);
        }
    }

    private static void permutation(int count) {
        if (count==m) {
            for (int i = 0; i < m; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSelected[i]) continue;

            numbers[count] = input[i];

            isSelected[i] = true;

            permutation(count + 1);

            isSelected[i] = false;

        }

    }
}
