package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main_20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] nkqm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nkqm[0];
        int k = nkqm[1];
        int q = nkqm[2];
        int m = nkqm[3];

        int[] students = new int[n+3];
        for (int i =0; i < n+3; i++) {
            students[i] = 1;
        }

        List<Integer> ks = Arrays.stream(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());

        int[] att = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int a : att) {
            if (ks.contains(a)) {   // 코드 받은 학생이 졸고 있을 경우
                continue;
            }

            for (int i = 1; i*a < n+3; i++) {
                if (!ks.contains(i*a)) {    // 졸고 있지 않은 학생일 경우
                    students[i * a] = 0;
                }
            }
        }


        for (int i = 1; i < n+3; i++) {
            students[i] += students[i-1];
        }

        for (int i = 0; i < m; i++) {
            int[] se = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = se[0];
            int end = se[1];

            sb.append(students[end] - students[start-1]).append("\n");
        }

        System.out.println(sb);

    }
}
