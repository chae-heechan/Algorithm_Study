package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 브론즈 2
// 백설 공주와 일곱 난쟁이
public class Main_3040 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        int notNanjeng1 = 0;
        int notNanjeng2 = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        for (int i = 0; i < 9; i++) {
            for(int j = 1; j < 9; j++) {
                if (arr[i] + arr[j] == sum - 100) {
                    notNanjeng1 = i;
                    notNanjeng2 = j;
                    break;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i == notNanjeng1 || i == notNanjeng2) continue;

            System.out.println(arr[i]);
        }


    }




}
