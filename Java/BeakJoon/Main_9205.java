package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 골드 5
// 맥주 마시면서 걸어가기
public class Main_9205 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static Queue<Conveniencia> queue = new LinkedList<>();
    static int[][] conveniencias;
    static Conveniencia end;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            n = Integer.parseInt(br.readLine());

            conveniencias = new int[n][2];
            visited = new boolean[n];
            queue.clear();

            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            queue.add(new Conveniencia(temp[0], temp[1]));
            for (int i = 0; i < n; i++) {
                conveniencias[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

            temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            end = new Conveniencia(temp[0], temp[1]);

            if (bfs()) {
                System.out.println("happy");
            }
            else {
                System.out.println("sad");
            }
        }
    }

    static boolean bfs() {
        while(!queue.isEmpty()) {
            Conveniencia con = queue.poll();
            // 끝에 도달 한경우 종료
            if (Math.abs(con.r - end.r) + Math.abs(con.c - end.c) <= 1000){
                return true;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int nextR = conveniencias[i][0];
                    int nextC = conveniencias[i][1];
                    int dis = Math.abs(con.r - nextR) + Math.abs(con.c - nextC);
                    if (dis <= 1000) {
                        visited[i] = true;
                        queue.add(new Conveniencia(conveniencias[i][0], conveniencias[i][1]));
                    }
                }
            }
        }

        // 큐가 비어서 더이상 이동할 수 없을 경우 종료
        return false;
    }
}

class Conveniencia {
    int r;
    int c;

    Conveniencia(int r, int c) {
            this.r = r;
            this.c = c;
    }
}
