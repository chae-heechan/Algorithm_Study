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

            Stack<Character> stack = new Stack<>();

            for (char bracket : br.readLine().toCharArray()) {
                // 열린 괄호가 들어올 경우 무조건 push
                if (bracket == '(' || bracket == '{' || bracket == '[' || bracket == '<') {
                    stack.push(bracket);
                    continue;
                }else if(stack.isEmpty()){      // 닫힌 괄호 이면서 Stack이 비어있을 경우 answer = 0
                    answer = 0;
                    break;
                }

                // 입력된 괄호가 닫힌 괄호이고 Stack의 peek과 같은 괄호일 경우 pop
                if (stack.peek() == '(' && bracket == ')') {
                    stack.pop();
                    continue;
                }

                if (stack.peek() == '{' && bracket == '}') {
                    stack.pop();
                    continue;
                }

                if (stack.peek() == '[' && bracket == ']') {
                    stack.pop();
                    continue;
                }

                if (stack.peek() == '<' && bracket == '>') {
                    stack.pop();
                    continue;
                }

                // 들어온 입력이 맞지 않은 경우 answer = 0
                answer = 0;
                break;

            }

            // 스택이 비어있지 않을 경우 answer = 0
            if (!stack.isEmpty())
                answer = 0;

            System.out.printf("#%d %d\n", t, answer);
        }


    }
}
