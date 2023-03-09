package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 골드 3
// 뒤집기 게임
public class Main_23058 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int n;

    static int[] numbers;
    static List<Integer>[] l;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        l = new ArrayList[(int)Math.pow(2, n*2)];

        for (int i = 0; i < (int)Math.pow(2, n*2); i++) {
            l[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // r부분집합, c부분집합

        numbers = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            numbers[i] = i;
        }

        bit(numbers, n * 2);

        System.out.println(calculate());
    }

    private static void bit(int[] arr, int n) {
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    System.out.printf("%d ", arr[j]);
                    l[i].add(arr[j]);
                }
            }
            System.out.println();
        }
    }

    private static int calculate() {
        // 뒤집을때마다 카운트1 세고
        // 1일때마다 카운트2 해서
        // 가장 작은 turn + count 출력
        int min = Integer.MAX_VALUE;
        int turn, oneCount, zeroCount;
        int[][] newMap;
        for (int i = 0; i < l.length; i++) {
            turn = l[i].size();
            oneCount = zeroCount = 0;
            newMap = map;

            // 부분함수만큼 뒤집기
            for (int j = 0; j < l[i].size(); j++) {
                int rc = l[i].get(j);
                if (rc < n) {  // row
                    for (int c = 0; c < n; c++) {
                        newMap[rc][c] = 1 - newMap[rc][c];
                    }
                }else {     // col
                    rc -= n;
                    for (int r = 0; r < n; r++) {
                        newMap[r][rc] = 1 - newMap[r][rc];
                    }
                }

                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (newMap[r][c] == 1) {
                            oneCount++;
                        } else {
                            zeroCount++;
                        }
                    }
                }
            }
            turn += Math.min(oneCount, zeroCount);
            min = Math.min(min, turn);
        }

        return min;
    }
}
