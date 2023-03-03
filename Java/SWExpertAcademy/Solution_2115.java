package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// SW 역량테스트
// 벌꿀채취
public class Solution_2115 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int n, m, c;

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            sb.append("#").append(t).append(" ");

            int[] nmc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            n = nmc[0];     // 벌통 크기
            m = nmc[1];     // 선택할 수 있는 벌통 개수
            c = nmc[2];     // 꿀 최대 양

            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            //
        }

    }

    private static int calculateProfit(int x, int c) {
        // 리스트 구해서 combination
        int[] newL = new int[m];
        for (int i = 0; i < m; i++) {
            newL[i] = map[x][c+i];
        }

        // 그 리스트로  합 구해서 리턴
        int[] maxL = combination(newL);
        int result = 0;
        for (int data : maxL) {
            result += Math.pow(data, 2);
        }

        return result;
    }

    private static int[] combination(int[] l) {
        // c 안넘는 최대 리스트 반환

        return ;
    }
}
