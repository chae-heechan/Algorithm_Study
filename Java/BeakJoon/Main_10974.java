import java.util.Scanner;

public class Main_10974 {
    public static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] output = new int[n];
        int[] visited = new int[n];

        permutation(output, visited, 0, n, n);

        System.out.println(sb);
    }

    // n 개중에 r 개 뽑기
    public static void permutation(int[] output, int[] visited, int depth, int n, int r){
        if (depth == r){
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++){
            if (visited[i] == 0){
                visited[i] = 1;
                output[depth] = i+1;
                permutation(output, visited, depth+1, n, r);
                visited[i] = 0;
            }
        }

    }

    public static void print(int[] output, int r) {
        for(int i = 0; i < r; i++){
            sb.append(output[i] + " ");
        }
        sb.append("\n");
    }
}
