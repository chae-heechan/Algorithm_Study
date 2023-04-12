package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 실버 3
// Java vs C++
public class Main_3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        // C++
        if (str.contains("_")) {
            for(int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == '_') {
                    if (i == str.length()-1 || i == 0) {
                        System.out.println("Error!");
                        return;
                    }
                    if (str.charAt(i+1) < 97 || str.charAt(i+1) > 122 ) {
                        System.out.println("Error!");
                        return;
                    }

                    sb.append(Character.toUpperCase(str.charAt(i+1)));
                    i++;
                }else {
                    if (str.charAt(i) < 97 || str.charAt(i) > 122 ) {
                        System.out.println("Error!");
                        return;
                    }
                    sb.append(str.charAt(i));
                }
            }
        } else {    // JAVA

            if (str.charAt(0) < 97 || str.charAt(0) > 122) {
                System.out.println("Error!");
                return;
            }

            for(char c : str.toCharArray()) {
                if (c >= 65 && c <= 90) {
                    char upperCase = Character.toLowerCase(c);
                    sb.append('_').append(upperCase);
                }else {
                    sb.append(c);
                }
            }

        }

        System.out.println(sb);
    }
}

