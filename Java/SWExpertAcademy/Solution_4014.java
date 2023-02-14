package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// SW 역량테스트
// 활주로 건설
public class Solution_4014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            int[] nx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int n = nx[0];
            int x = nx[1];
            int count = 0;

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int check;

            // [0][0]에서 [0][n-2]까지 돌면서 위아래로 탐색
            for (int i = 0; i < n - 1; i++) {
                check = 0;
                for (int j = 0; j < n - 1; j++) {
                    // 다음 거랑 비교
                    // 높이가 올라가면 내 뒤랑 높이가 같은지
                    // 높이가 낮아지면 그 앞이랑 높이가 같은지
                    if (arr[i][j] == arr[i][j+1]) {     // 높이가 같을 경우
                        continue;
                    } else if (arr[i][j] < arr[i][j+1]) {   // 높이가 올라갈 경우 -> 이전칸과 비교
                        if (j-1 >= 0 && arr[i][j] == arr[i][j-1]) {     // j-1이 0보다 크거나 같고, 이전 칸과 같은 높이일 경우
                            continue;
                        }else {     // 이전 칸이 없거나 높이가 다를 경우
                            check = 1;
                            break;
                        }
                    } else if (arr[i][j] > arr[i][j+1]) {      // 높이가 내려갈 경우 -> 다음칸과 그 다음칸을 비교
                        if (j+2 <= n-1 && arr[i][j+1] == arr[i][j+2]) {     // 그 다음칸이 마지막칸보다 작거나 같고, 다음칸과 같은 높이일 경우
                            continue;
                        }else {     // 그 다음 칸이 없거나 높이가 다를 경우
                            check = 1;
                            break;
                        }
                    }
                }
                if (check == 0) {
                    count++;
                }
            }

            // [0][0]에서 [n-2][0]까지 돌면서 좌우로 탐색
            for (int j = 0; j < n - 1; j++) {
                for (int i = 0; i < n - 1; i++) {
                    // 높이가 올라가면 내 뒤랑 높이가 같은지

                    // 높이가 낮아지면 그 앞이랑 높이가 같은지
                }
            }

            System.out.println(count);

        }
    }
}
