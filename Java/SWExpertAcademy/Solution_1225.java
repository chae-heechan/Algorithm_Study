package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.append("#" +br.readLine());  // 테케 번호 날리기
            int flag = 0;

            Queue<Integer> queue = new LinkedList<>();

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int data : input){
                queue.offer(data);
            }

            // 돌면서 앞에 수 빼고 뒤에 추가
            while(flag == 0) {
                for (int i = 1; i <= 5; i++) {
                    if ((queue.peek() - i) <= 0) {   // 감소후 0 이하일 경우
                        queue.poll();
                        queue.offer(0);
                        for (int p = 0; p < 8; p++) {
                            sb.append(" "+ queue.poll());
                        }
                        System.out.println(sb);
                        sb = new StringBuilder();
                        flag = 1;
                        break;
                    }

                    // 일반적인 경우
                    queue.offer(queue.poll() - i);

                }
            }
        }

    }
}
