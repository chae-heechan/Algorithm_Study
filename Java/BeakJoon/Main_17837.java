package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17837 {
    static int[][] board;
    static Caballo[] caballos;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      크기, 말 개수
        int[] gameInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//      체스판 초기화
        int n = gameInfo[0];
        board = new int[n][n];

//      말 목록 초기화
        int k = gameInfo[1];
        caballos = new Caballo[k];

//      길 입력받기
        for (int i = 0 ; i < n; i++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

//      말 입력받고 목록에 추가
        Caballo caballo;
        for (int i = 0; i < k; i++){

//            caballo  = new Caballo();
//            caballos[i] = caballo;
        }
    }
}

class Caballo {

    public Caballo(int[] caballoInfo){
        this.r = r;
        this.c = c;
        this.direccion = direccion;
    }
    int num, r, c, direccion;
}