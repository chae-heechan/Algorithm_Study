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
    static int[][] profit;
    static int n, m, c;
    static int answer;

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            sb.append("#").append(t).append(" ");

            int[] nmc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            n = nmc[0];     // 벌통 크기
            m = nmc[1];     // 선택할 수 있는 벌통 개수
            c = nmc[2];     // 꿀 최대 양

            map = new int[n][n];
            profit = new int[n][n];
            answer = 0;

            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            // 수익 미리 계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - m; j++) {
                    calculateProfit(i, j, 0, 0, 0);
                }
            }

            // 구역 나누기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    divideSection(i, j + m, 1, profit[i][j]);
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void calculateProfit(int i, int j, int count, int sum, int total) {
        // 최대 양을 넘을 경우 끝내기
        if (sum > c) return;
        if (count == m) {   // 모든 벌통 선택한 경우
            profit[i][j - m] = Math.max(profit[i][j - m], total);
            return;
        }

        // 아직 안끝난 경우
        // 벌통 추가
        calculateProfit(i, j + 1, count + 1, sum + map[i][j], total + (int) Math.pow(map[i][j], 2));
        // 벌통 안추가
        calculateProfit(i, j + 1, count + 1, sum, total);
    }


    private static void divideSection(int x, int y, int count, int sum) {
        if (count == 2) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = x; i < n; i++) {
            for (int j = y; j <= n - m; j++) {
                divideSection(i, j, count + 1, sum + profit[i][j]);
            }
            y = 0;
        }

        return;
    }
}
