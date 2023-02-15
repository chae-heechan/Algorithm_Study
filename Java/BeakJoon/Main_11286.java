package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 실버 1
// 절대값 힙
public class Main_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) return o1 - o2;
            return abs1 - abs2;
        });

        for (int i = 0; i < n; i++){
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {   // 0일 경우
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                }else {
                    sb.append(pq.poll()).append("\n");
                }
            }else { // 0이 아닐 경우
                pq.add(input);
            }

        }

        System.out.println(sb);
    }
}
