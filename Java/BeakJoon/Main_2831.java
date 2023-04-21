package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 골드 4
// 댄스 파티
public class Main_2831 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;

        // -남자 오름차순
        PriorityQueue<Integer> minusChicosAsc = new PriorityQueue<>();
        // +남자 내림차순
        PriorityQueue<Integer> plusChicosDesc = new PriorityQueue<>(Collections.reverseOrder());
        // +여자 오름차순
        PriorityQueue<Integer> plusChicasAsc = new PriorityQueue<>();
        // -여자 내림차순
        PriorityQueue<Integer> minusChicasDesc = new PriorityQueue<>(Collections.reverseOrder());


        int n = Integer.parseInt(br.readLine());

        // 남자 키 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (height > 0) {
                plusChicosDesc.add(Math.abs(height));
            } else {
                minusChicosAsc.add(Math.abs(height));
            }
        }

        // 여자 키 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (height > 0) {
                plusChicasAsc.add(Math.abs(height));
            } else {
                minusChicasDesc.add(Math.abs(height));
            }
        }

        // 남자가 더 큰 커플
        while (!minusChicosAsc.isEmpty() && !plusChicasAsc.isEmpty()) {
            // 남자가 더 큰 경우
            if(minusChicosAsc.peek() > plusChicasAsc.peek()) {
                minusChicosAsc.poll();
                plusChicasAsc.poll();
                count++;
            }else { // 여자가 더 큰 경우
                minusChicosAsc.poll();  // 작은 남자 삭제
            }
        }

        // 여자가 더 큰 커플
        while(!plusChicosDesc.isEmpty() && !minusChicasDesc.isEmpty()) {
            // 여자가 더 큰 경우
            if(plusChicosDesc.peek() < minusChicasDesc.peek()) {
                plusChicosDesc.poll();
                minusChicasDesc.poll();
                count++;
            } else {    // 남자가 더 큰 경우
                plusChicosDesc.poll();
            }
        }

        System.out.println(count);


    }
}
