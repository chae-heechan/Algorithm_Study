package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;

        int n = Integer.parseInt(br.readLine());

        int cutCount = (int)Math.round(n*0.15);

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i < cutCount; i++) {
            pq.poll();
        }

        for (int i = 0; i < n - cutCount * 2; i++) {
            sum += pq.poll();
        }

        long answer = Math.round((double)sum/(n-2*cutCount));

        System.out.println(answer);
    }
}
