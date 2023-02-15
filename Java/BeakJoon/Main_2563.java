package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 실버 5
// 색종이
public class Main_2563 {
    private static final int SIZE = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int[][] arr = new int[SIZE][SIZE];

        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            int[] line = Arrays.stream((br.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
            int x = line[0];
            int y = line[1];
            int a = x + 10;
            int b = y + 10;

            for (int i = x; i < a; i++){
                for (int j = y; j < b; j++) {
                    arr[i][j] = 1;
                }
            }

        }

        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++) {
                if (arr[i][j] == 1) {
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}
