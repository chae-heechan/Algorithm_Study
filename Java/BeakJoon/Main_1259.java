package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int[] palindrome = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            if (palindrome[0] == 0) break;

            int n = palindrome.length;
            boolean isPalindrome = true;

            for (int i = 0; i < n / 2; i++) {
                if (palindrome[i] != palindrome[n - 1 - i]) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }

        }

        System.out.println(sb);
    }
}
