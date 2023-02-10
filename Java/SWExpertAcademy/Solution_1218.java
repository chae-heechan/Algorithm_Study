package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {

            int answer = 1;

            int n = Integer.parseInt(br.readLine());

            char[] brackets = br.readLine().toCharArray();

            Stack<Character> a = new Stack<>();

            for (char bracket : brackets) {
                if (a.isEmpty() || bracket == '(' || bracket == '{' || bracket == '[' || bracket == '<') {
                    a.push(bracket);
                    continue;
                }

                if (a.peek() == '(' && bracket == ')') {
                    a.pop();
                    continue;
                } else if (a.peek() == '{' && bracket == '}') {
                    a.pop();
                    continue;
                } else if (a.peek() == '[' && bracket == ']') {
                    a.pop();
                    continue;
                } else if (a.peek() == '<' && bracket == '>') {
                    a.pop();
                    continue;
                }

                answer = 0;

            }

            System.out.printf("#%d %d\n", t, answer);
        }


    }
}
