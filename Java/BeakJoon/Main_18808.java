package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 스티커 붙이기
public class Main_18808 {
    static int N, M, K;
    static int[][] map;
    static Sticker[] stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = nmk[0];
        M = nmk[1];
        K = nmk[2];
        map = new int[N][M];
        stickers = new Sticker[K];

        for (int i = 0; i < K; i++) {
            int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Sticker newSticker = new Sticker(rc[0], rc[1]);
            for (int j = 0; j < rc[0]; j++) {
                newSticker.grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            stickers[i] = newSticker;
        }


        for (int s = 0; s < K; s++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    // 해당 칸이 비어있을 경우
                    if (map[x][y] == 0) {
                        for (int i = 0; i < 4; i++) {
                            // 스티커 공간이 없을 경우
                            if (stickers[s].r+x >= N && stickers[s].c+y >= M) {
                                stickers[s].rotate();
                            }
                        }


                    }
                }
            }
        }

    }
}

class Sticker {
    int r;
    int c;
    int[][] grid;

    Sticker(int r, int c) {
        this.r = r;
        this.c = c;
        this.grid = new int[r][c];
    }

    public void rotate() {
        int[][] newGrid = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newGrid[j][r - i - 1] = this.grid[i][j];
            }
        }
        this.grid = newGrid;
    }
}
