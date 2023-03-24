package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실버 3
// NBA 농구
public class Main_2852 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int gameTime = 48 * 60;
    static int prev, curr;
    static int score;   // 양수일 경우 a 승
    static int a, b;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());

            prev = curr;

            st = new StringTokenizer(st.nextToken(), ":");
            curr = Integer.parseInt(st.nextToken()) * 60;   // 분 계산
            curr += Integer.parseInt(st.nextToken());    // 초 계산

            countTime(curr, prev);

            if (team == 1) {
                score++;
            } else {
                score--;
            }
        }

        countTime(gameTime, curr);

        sb.append(String.format("%2d", a/60).replace(" ", "0")).append(":").append(String.format("%2d", a%60).replace(" ", "0")).append("\n");
        sb.append(String.format("%2d", b/60).replace(" ", "0")).append(":").append(String.format("%2d", b%60).replace(" ", "0")).append("\n");

        System.out.println(sb);
    }

    private static void countTime(int c, int p) {
        if (score > 0) {    // a가 이기고 있었을 경우
            a += c - p;
        } else if (score < 0) { // b가 이기오 있었을 경우
            b += c - p;
        }
    }
}
