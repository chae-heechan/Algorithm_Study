package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String comm = br.readLine();

            if (comm.equals("top")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.peek()).append("\n");
                } else {
                    sb.append("-1\n");
                }
            }
            else if (comm.equals("size")) {
                sb.append(stack.size()).append("\n");
            }
            else if (comm.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append("1\n");
                }else {
                    sb.append("0\n");
                }
            }
            else if (comm.equals("pop")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append("-1\n");
                }
            }
            else {
                String[] push = comm.split(" ");
                stack.push(Integer.parseInt(push[1]));
            }
        }

        System.out.println(sb);
    }
}
