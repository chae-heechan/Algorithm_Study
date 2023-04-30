package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

// LOL
public class Main_11140 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String pattern = "[a-z]*l[a-z]l[a-z]*";

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            if (str.contains("lol")){
                sb.append("0\n");
            } else if (str.contains("lo") || str.contains("ol") || str.contains("ll") || Pattern.matches(pattern, str)){
                sb.append("1\n");
            } else if (str.contains("l") || str.contains("o")){
                sb.append("2\n");
            } else {
                sb.append("3\n");
            }
        }

        System.out.println(sb);
    }
}
