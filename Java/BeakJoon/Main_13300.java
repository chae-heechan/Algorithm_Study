package BeakJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] estYK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int estudiantes = estYK[0];
        int K = estYK[1];

        int habitacion = 0;

        int[][] clases = new int[6][2];

        for(int i = 0; i < estudiantes; i++) {
            int[] estudiante = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            clases[estudiante[1]-1][0]++;
        }

        for(int i = 0; i < 6 ; i++){
            for (int j = 0; j < 2; j++){
                System.out.printf("  %d학년 %d성별 = %d", i+1, j, clases[i][j]);
                if (clases[i][j]!=0)
                    habitacion += (clases[i][j]/K);
                if (clases[i][j] % 2 == 1)
                    habitacion++;
            }
        }

        System.out.println(habitacion);
    }
}
