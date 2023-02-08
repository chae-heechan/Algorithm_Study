package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// D3
// 농작물 수확하기
public class Solution_2805 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int talla;
    static int[][] hacienda;

    public static void main(String[] args) throws IOException {

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++){
            int ganancia = 0;
            int alcance = 1;

            talla = Integer.parseInt(br.readLine());

            hacienda = new int[talla][talla];

            for (int i = 0; i < talla; i++) {
                hacienda[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            int comienzo = talla/2;

            for (int i = 0; i < talla/2; i++){
                for (int j = comienzo; j < comienzo +alcance; j++){
                    ganancia += hacienda[i][j];
                }
                comienzo -= 1;
                alcance += 2;
            }
            for (int i = talla/2; i < talla; i++){
                for (int j = comienzo; j < comienzo +alcance; j++){
                    ganancia += hacienda[i][j];
                }
                comienzo += 1;
                alcance -= 2;
            }

            System.out.printf("#%d %d\n", t, ganancia);


        }
    }
}
