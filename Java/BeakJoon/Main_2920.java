package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] sounds = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (sounds[0] == 1) {
            for (int i = 1; i < 8; i++) {
                if (sounds[i] != i + 1) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
        } else if (sounds[0] == 8) {
            for (int i = 1; i < 8; i++) {
                if (sounds[i] != 8 - i) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
