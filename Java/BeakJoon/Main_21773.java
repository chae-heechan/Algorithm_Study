package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 골드 5
// 가희와 프로세스 1
public class Main_21773 {
    static int t, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Process> pq = new PriorityQueue<>();

        int[] tn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        t = tn[0];
        n = tn[1];

        for (int i = 0; i < n; i++) {
            int[] np = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.add(new Process(np[0], np[1], np[2]));
        }

        for (int i = 0 ; i < t; i++) {
            Process p = pq.poll();
            sb.append(p.id).append("\n");
            p.priority--;
            p.time--;
            if (p.time > 0) {
                pq.add(p);
            }

            if (pq.isEmpty()){
                break;
            }
        }
        System.out.println(sb);
    }
}

class Process implements Comparable<Process> {
    int id;
    int time;
    int priority;

    @Override
    public int compareTo(Process o) {
        if (this.priority == o.priority) {
            return this.id - o.id;
        }

        return o.priority - this.priority;
    }

    protected Process(int id, int time, int priority) {
        this.id = id;
        this.time = time;
        this.priority = priority;
    }
}
