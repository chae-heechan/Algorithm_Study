package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 실버 5
// 스네이크버드
public class Main_16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nl = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int l = nl[1];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int data : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
            if (data <= l) {    // 바로 먹을 수 있는 경우
                l++;
            }else { // 먹을 수 없는 경우
                pq.offer(data);
            }
        }

        while (!pq.isEmpty()) {
            if (pq.poll() <= l) {
                l++;
            }else {
                break;
            }
        }

        System.out.println(l);
    }
}
