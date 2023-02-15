package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// D4
// 정사각형 방
public class Solution_1861 {
    static int n;
    static int[][] arr;
    static int[][] visited;

    static int[] dr = {0, 0, 1, -1};    // 우 좌 하 상
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            int max = 0;
            int value = 0;

            n = Integer.parseInt(br.readLine());

            arr = new int[n][n];
            visited = new int[n][n];

            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int count = dfs(1, i, j);

                    if(count > max){
                        max = count;
                        value = arr[i][j];
                    }else if (count == max) {
                        max = count;
                        value = Math.min(value, arr[i][j]);
                    }
                }
            }
            sb.append("#" + t + " " + value + " " + max + "\n");

        }

        System.out.println(sb);
    }

    private static int dfs(int count, int r, int c) {

        for (int i = 0; i < 4; i++) {
            int nextR = r+dr[i];
            int nextC = c+dc[i];
            if (nextR >= 0 && nextR < n
                && nextC >= 0 && nextC < n
                && visited[nextR][nextC] == 0
                && arr[r][c] + 1 == arr[nextR][nextC]) {
                count++;
                count = dfs(count, r+dr[i], c+dc[i]);
            }
        }

        return count;
    }


}
