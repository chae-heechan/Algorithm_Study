package BeakJoon;

import java.util.Scanner;

// 브론즈 3
// 중앙 이동 알고리즘
public class Main_2903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] points = new int[16];
        points[0] = 2;

        for (int i = 1; i <= n; i++) {
            points[i] = points[i-1] + points[i-1] - 1;
        }

        System.out.println(points[n] * points[n]);

    }
}
