package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());


        while(true) {
            if (t.charAt(t.length()-1) == 'A') {    // 가장 뒤 값이 A일 경우
                t.delete(t.length()-1, t.length());
            }
            else if (t.charAt(t.length()-1) == 'B') {  // 가장 뒤 값이 B일 경우
                t.delete(t.length()-1, t.length());
                t.reverse();
            }
            else {  // 가장 뒤 값이 다른 값일 경우
                System.out.println(1);
                break;
            }

            if (t.length() == s.length()) {
                if (t.toString().equals(s.toString())) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
                break;
            }
        }



    }
}
