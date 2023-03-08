package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 골드 3
// 뒤집기 게임
public class Main_23058 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int n;

    static int totalCount;

    static int[] input;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

//        for (int i = 0; i < n; i++) {
//            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        }

        // r부분집합, c부분집합

        input = new int[n];
        isSelected = new boolean[n];
        for (int i = 0; i < n; i++) {
            input[i] = i;
        }

        generateSubSet(0);
        System.out.println(totalCount);
    }

    private static void generateSubSet(int count) { // count: 현재까지 고려한 원소 수

        if(count==n) {
            ++totalCount;
            for(int i=0; i<n; ++i) {
                if (isSelected[i]) {

                }
                System.out.print((isSelected[i]?input[i]:"X")+" ");
            }
            System.out.println();
            return;
        }
        isSelected[count] = true;
        generateSubSet(count+1);
        isSelected[count] = false;
        generateSubSet(count+1);
    }
}
