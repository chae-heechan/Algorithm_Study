import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1289 {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++){
            count = 0;
            int[] memory = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            String.valueOf(recursive(memory));
            System.out.printf("#%d %d\n", i, count);
        }
    }

    public static int[] recursive(int[] memory) {
        if (memory[0] == 1){
            count++;
            for(int i = 0; i < memory.length; i++){
                memory[i] = 1 - memory[i];
            }
        }

        if (memory.length == 1) {
            return memory;
        }

        int[] slicedMemory = Arrays.copyOfRange(memory, 1, memory.length);
        int[] newMemory = new int[memory.length];
        System.arraycopy(memory,0, newMemory, 0, 1);
        System.arraycopy(recursive(slicedMemory), 0, newMemory, 1, memory.length-1);

        return newMemory;
    }
}
