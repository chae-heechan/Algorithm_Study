package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A, B, N;    // 걸리는 시간, 손님 수
        Queue<Integer> sangmin = new LinkedList<>();
        Queue<Integer> jisoo = new LinkedList<>();
        int sEndPackTime = 0;
        int jEndPackTime = 0;
        StringBuilder sAnswer = new StringBuilder();
        StringBuilder jAnswer = new StringBuilder();

        int[] abn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        A = abn[0];
        B = abn[1];
        N = abn[2];

        for (int customer = 0; customer < N; customer++) {
            String[] tcm = br.readLine().split(" ");
            int t = Integer.parseInt(tcm[0]);
            String c = tcm[1];
            int m = Integer.parseInt(tcm[2]);

            if (c.equals("B")) {
                if (sEndPackTime > t) t = sEndPackTime;
                int currentTime = t;
                for (int g = 0; g < m; g++) {
                    sangmin.offer(currentTime);
                    currentTime += A;
                }
                sEndPackTime = currentTime;
            } else {
                if (jEndPackTime > t) t = jEndPackTime;
                int currentTime = t;
                for (int g = 0; g < m; g++) {
                    jisoo.offer(currentTime);
                    currentTime += B;
                }
                jEndPackTime = currentTime;
            }
        }

        sAnswer.append(sangmin.size()).append("\n");
        jAnswer.append(jisoo.size()).append("\n");

        int count = 1;

        while(!sangmin.isEmpty() && !jisoo.isEmpty()) {
            if (sangmin.peek() <= jisoo.peek()) {    // 상민이가 더 이를 경우
                sangmin.poll();
                sAnswer.append(count++).append(" ");
            } else {
                jisoo.poll();
                jAnswer.append(count++).append(" ");
            }
        }

        if (sangmin.isEmpty()) {
            while(!jisoo.isEmpty()) {
                jisoo.poll();
                jAnswer.append(count++).append(" ");
            }
        } else if (jisoo.isEmpty()) {
            while(!sangmin.isEmpty()){
                sangmin.poll();
                sAnswer.append(count++).append(" ");
            }
        }

        System.out.println(sAnswer);
        System.out.println(jAnswer);

    }
}
