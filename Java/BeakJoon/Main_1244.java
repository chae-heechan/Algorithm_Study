import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1244 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int cuenta;
    static int[] interruptores;
    static int estudiantes;
    public static void main(String[] args) throws IOException {

        cuenta = Integer.parseInt(br.readLine());

        interruptores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        estudiantes = Integer.parseInt(br.readLine());

        for(int i = 0; i < estudiantes; i++){
            int[] estudiante = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(estudiante[0] == 1){     // 남자일 경우
                for(int j = estudiante[1]; j <= cuenta; j += estudiante[1]){
                    interruptores[j-1] = 1 - interruptores[j-1];
                }
            }else {     // 여자일 경우
                int left = estudiante[1]-1;
                int right = estudiante[1]-1;

                while(left-1 >= 0 && right+1 <= cuenta-1) {
                    if (interruptores[left-1] == interruptores[right+1]){
                        left--;
                        right++;
                    }
                    else{
                        break;
                    }
                }
                for (int j = left; j <= right;j++){
                    interruptores[j] = 1 - interruptores[j];
                }
            }

        }

        for(int i = 0; i < cuenta; i++){
            System.out.printf("%d ",interruptores[i]);
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }

    }
}
