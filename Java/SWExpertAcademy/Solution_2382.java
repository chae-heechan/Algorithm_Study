package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_2382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <=TC; t++) {
            int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int n = nmk[0];     // int[n][n]
            int m = nmk[1];     // m 시간
            int k = nmk[2];     // 군집 개수

            ArrayList<Microbe> arr = new ArrayList<>();

            
            // 2차원 배열 만들기

            for (int i = 0; i < k; i++) {

            }

        }
    }

}

class Microbe {
    int amount;
    int index;
    int direction;

    public Microbe(int amount, int index, int direction) {
        this.amount = amount;
        this.index = index;
        this.direction = direction;
    }
}
