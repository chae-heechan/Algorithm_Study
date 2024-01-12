package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            ArrayList<Integer>[] alphabet = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                alphabet[i] = new ArrayList<Integer>();
            }

            char[] w = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());

            // alphabet index 넣기
            for (int i = 0;  i < w.length; i++) {
                alphabet[w[i]-97].add(i);
            }

            int min = 10001;
            int max = 0;

            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i].size() < k) {
                    continue;
                }

                for (int j = 0; j <= alphabet[i].size() - k; j++) {
                    min = Math.min(min, alphabet[i].get(j + k - 1) - alphabet[i].get(j) + 1);
                    max = Math.max(max, alphabet[i].get(j + k - 1) - alphabet[i].get(j) + 1);
                }
            }

            if (min == 10001 || max == 0) {
                System.out.println("-1");
            } else {
                System.out.println(min + " " + max);
            }

        }
    }
}
