import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1208 {
    private static final int SIZE = 100;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[SIZE];
    public static void main(String[] args) throws IOException {
        int left = 0;
        int right = SIZE-1;

        for (int tc = 1; tc <= 10; tc++) {

            int count = Integer.parseInt(br.readLine());

            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(arr);

            for (int i = 0; i < count; i++) {
                if (arr[right] - arr[left] <= 1) {
                    System.out.println(1);
                    return;
                }


                if (arr[left] > arr[left + 1] || arr[right - 1] > arr[right])
                    Arrays.sort(arr);

                arr[left]++;
                arr[right]--;
            }

            Arrays.sort(arr);
            System.out.printf("#%d %d\n", tc, arr[right] - arr[left]);
        }
    }
}
