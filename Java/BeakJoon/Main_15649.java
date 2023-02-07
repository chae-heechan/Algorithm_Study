import java.util.Scanner;

public class Main_15649 {
    static int n;
    static int m;
    static int count;
    static int[] arr;
    static int[] visited;

    public static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        visited = new int[n];

        permutation(0, n, m);

    }

    public static void permutation(int now, int n, int m){
        if (now >= m){
            count++;
            print();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            arr[now] = i + 1;
            permutation(now + 1, n, m);
            visited[i] = 0;
        }

    }

    public static void print(){
        for (int i = 0; i < m;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
