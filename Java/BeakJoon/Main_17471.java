package BeakJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// 골드 4
// 게리맨더링
public class Main_17471 {
    static int[][] edges;
    static int[] population;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        edges = new int[n][n];

        for (int i = 0; i < n; i++) {
            population[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();

            for (int j = 0; j < k; j++) {
                edges[i][j] = sc.nextInt();
            }
        }



    }

    private static void makeSet() {

    }
}
