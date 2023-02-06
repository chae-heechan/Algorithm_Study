import java.util.Scanner;

public class Main_1012 {

    static int Y;
    static int X;
    static int[][] datos;
    static int[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for (int t = 0; t < TC; t++) {
            int cuenta = 0;
            Y = sc.nextInt();
            X = sc.nextInt();
            int cuentaDeCol = sc.nextInt();

            datos = new int[X][Y];
            visited = new int[X][Y];

            for (int i = 0; i < cuentaDeCol; i++) {
                int y = sc.nextInt();
                int x = sc.nextInt();

                datos[x][y] = 1;
            }

            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++){
                    if (datos[i][j] == 1 && visited[i][j] == 0) {
                        cuenta++;
                        dfs(i, j);
                    }
                }
            }
            // 이동하다가 1만나면 dfs

            System.out.println(cuenta);
        }
    }

    public static void dfs(int x, int y){
        visited[x][y] = 1;
        for(int i = 0; i < 4; i++) {
            if (x+dx[i] >= 0 && x+dx[i] < X && y+dy[i] >= 0 && y+dy[i]< Y) {
                if (datos[x + dx[i]][y + dy[i]] == 1 && visited[x+dx[i]][y+dy[i]] == 0) {
                    dfs(x+dx[i], y+dy[i]);
                }
            }
        }
    }


}
