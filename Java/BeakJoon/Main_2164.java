package BeakJoon;

import java.util.*;
// 실버 4
// 카드 2
public class Main_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++){
            queue.offer(i);
        }

        while (true) {
            if (queue.size() == 1) {
                System.out.println(queue.peek());
                return;
            }
            queue.poll();

            queue.offer(queue.poll());

        }

    }
}
