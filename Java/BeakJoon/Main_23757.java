package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 실버 2
// 아이들과 선물 상자
public class Main_23757 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static int[] w;

    public static void main(String[] args) throws IOException {
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];
        w = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        w = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < m; i++) {
            int gift = pq.poll();

            if (w[i] > gift) {
                System.out.println(0);
                return;
            }

            gift -= w[i];
            pq.offer(gift);
        }

        System.out.println(1);
        return;
    }
}
