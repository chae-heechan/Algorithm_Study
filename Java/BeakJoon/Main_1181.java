package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                }
                else if (o1.length() > o2.length()) {
                    return 1;
                }
                else {
                    return o1.compareTo(o2);
                }
            }
        });

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (!pq.contains(str)) {
                pq.add(str);
            }
        }

        int pqSize = pq.size();

        for (int i = 0; i < pqSize; i++) {
            System.out.println(pq.poll());
        }
    }
}
