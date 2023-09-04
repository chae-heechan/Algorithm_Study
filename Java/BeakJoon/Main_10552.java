package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 싫어하는 채널 - 사람1명(가장 어린 사람) 이동할 채널
 * visited에는 방문한 채널
 * 이미 방문한 채널이면 -1
 */
// 사람 수, 채널 수, 초기 채널
//        3 4 2
//        1 2
//        2 3
//        3 2

public class Main_10552 {
    static boolean[] visited;
    static int[] board;

    static Integer n, m, p;
    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nmp[0]; // 사람 수
        m = nmp[1]; // 채널 수
        p = nmp[2]; // 첫 채널

        visited = new boolean[m+1];
        board = new int[m+1];

        visited[p] = true;

        for (int i = 0; i < n; i++) {
            int[] channel = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


            if (board[channel[1]] == 0) {
                board[channel[1]] = channel[0];
            }

        }

        while (true) {
            if (board[p] == 0) { // 현재 채널을 싫어하는 사람이 없을 경우
                System.out.println(count);
                break;
            }

            p = board[p];
            count++;

            if (visited[p] == true) {  // 방문했던 채널일 경우
                System.out.println(-1);
                break;
            }

            visited[p] = true;


        }

    }
}
