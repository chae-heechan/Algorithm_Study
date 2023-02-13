package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// 골드 5
// 탑
public class Main_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] tops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Top> stack = new Stack<>();

        stack.push(new Top(0, 0));

        int index;

        for (int i = 0; i < n; i++) {
            index = -1;
            while (!stack.isEmpty()) {
                if (stack.peek().height <= tops[i]) {     // 현재 탑보다 같거나 작을 경우
                    stack.pop();
                }else {     // 현재 탑보다 클 경우
                    index = stack.peek().index;     // 인덱스에 큰 값 넣기
                    break;
                }
            }

            stack.push(new Top(tops[i], i));    // 스택에 현재 값 넣기

            sb.append(index+1).append(" ");

        }

        System.out.println(sb);
    }
}
class Top {
    int height;
    int index;

    public Top(int height, int index) {
        this.height = height;
        this.index = index;
    }
}