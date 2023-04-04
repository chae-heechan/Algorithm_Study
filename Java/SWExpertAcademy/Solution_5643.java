package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 키 순서
public class Solution_5643 {
    static int n, m;
    static int tallAndSmallCount;
    static ArrayList<Integer>[] smallMat;
    static ArrayList<Integer>[] tallMat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            sb.append("#").append(t).append(" ");
            int answer = 0;
            tallAndSmallCount = 0;
            n = Integer.parseInt(br.readLine())+1;    // 학생 수
            m = Integer.parseInt(br.readLine());    // 키를 비교한 횟수

            smallMat = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                smallMat[i] = new ArrayList<>();
            }

            tallMat = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                tallMat[i] = new ArrayList<>();
            }

            // 인접 행렬 생성
            for (int i = 0; i < m; i++) {
                int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                // a가 b보다 작음
                smallMat[ab[0]].add(ab[1]);
                // b가 a보다 큼
                tallMat[ab[1]].add(ab[0]);
            }

            // small, tall 돌면서 작거나 큰거 적기
            // 나보다 작은 학생수 + 나보다 큰 학생수 == 전체 - 1 이면 answer + 1
            for (int i = 1; i < n; i++) {
                tallAndSmallCount = 0;
                height(smallMat, i, 0, new boolean[n]);
                height(tallMat, i, 0, new boolean[n]);

                if ((n-2) == tallAndSmallCount) {
                    answer++;
                }

            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void height(ArrayList<Integer>[] mat, int i, int count, boolean[] visited) {
        visited[i] = true;
        for (int k : mat[i]) {
            if (!visited[k]) {
                height(mat, k, count + 1, visited);
                tallAndSmallCount++;
            }
        }
    }
}
