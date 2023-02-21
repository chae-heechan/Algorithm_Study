package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 실버 1
// 쿼드트리
public class Main_1992 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] video;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        video = new int[n][n];

        for (int i = 0; i < n; i++) {
            video[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        quadTree(0, 0, n);

        System.out.println(sb);
    }

    private static void quadTree(int r, int c, int size) {
        if (isPossibleToCompress(r, c, size)) {
            sb.append(video[r][c]);
            return;
        }

        int nextSize = size / 2;

        sb.append("(");

        quadTree(r, c, nextSize);   // 좌상
        quadTree(r, c + nextSize, nextSize);    // 우상
        quadTree(r + nextSize, c, nextSize);    // 좌하
        quadTree(r + nextSize, c + nextSize, nextSize); // 우하

        sb.append(")");
    }

    private static boolean isPossibleToCompress(int r, int c, int size) {
        int value = video[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (video[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }
}
