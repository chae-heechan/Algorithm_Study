package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue q = new PriorityQueue();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < n; i++) {
            sb.append(q.poll()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
