package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1120 {
    public static void main(String[] args) throws IOException {
        int minCount = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ab = br.readLine().split(" ");

        String a = ab[0];
        String b = ab[1];

        for (int start = 0; start <= b.length() - a.length(); start++) {
            int count = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(start + i)) {
                    count++;
                }
            }
            if (minCount > count) {
                minCount = count;
            }
        }

        System.out.println(minCount);

    }
}
