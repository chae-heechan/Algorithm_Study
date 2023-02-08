package BeakJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10163 {
    private static final int SIZE = 1001;
    public static void main(String[] args) throws IOException {
        int[] result = new int[SIZE];
        int[][] arr = new int[SIZE][SIZE];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int count = (int)(str.charAt(0)) - '0';

        for (int c = 1; c <= count; c++) {
            int[] line = Arrays.stream((br.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
            int x = line[0];
            int y = line[1];
            int a = line[3]+y;
            int b = line[2]+x;

            for (int i = x; i < a; i++){
                for (int j = y; j < b; j++) {
                    arr[i][j] = c;
                }
            }

        }

        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++) {
                if (arr[i][j] != 0) {
                    result[arr[i][j]]++;
                }
            }
        }

        for(int i = 1; i <= count; i++) {
            System.out.println(result[i]);
        }

    }
}
