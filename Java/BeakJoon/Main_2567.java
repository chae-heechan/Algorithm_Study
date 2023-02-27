package BeakJoon;

//맵에 검은 스카프를 1로 처리해 두고 사방탐색으로 r, c는 1이고 주변에 1칸이라도 0인 경우 둘레 + 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 실버 4
// 색종이 2
public class Main_2567 {
    static int[][] map = new int[100][100];	// 흰 스카프
    static int r, c;	// 검은 스카프 시작 좌표
    static int count;	// 둘레

    static int[] dr = {0, 0, 1, -1};	// 우, 좌, 하, 상
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 검은 스카프 개수 입력받기
        int n = Integer.parseInt(br.readLine());

        // 검은 스카프 좌표 입력 받기
        for (int m = 0; m < n; m++) {
            int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            r = rc[1];
            c = rc[0];

            // 검은 스카프 만큼 map을 1로 채우기
            for (int i = r; i < r+10; i++) {
                for (int j = c; j < c+10; j++) {
                    map[i][j] = 1;
                }
            }
        }

        // 횐 스카프를 돌며 둘레 확인하기
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                countBorderLine(i, j);
            }
        }

        System.out.println(count);

    }

    // 둘레 확인
    private static void countBorderLine(int i, int j) {
        int check = 0;
        if (map[i][j] == 1) {	// 검은스카프 일 경우
            for (int d = 0; d < 4; d++) {	// 사방 탐색
                int nextR = i + dr[d];
                int nextC = j + dc[d];

                if (!isPossibleToCheck(nextR, nextC)) {	// 흰 스카프의 끝일 경우
                    check++;	// 둘레 + 1
                }else {		// 흰 스카프의 끝이 아닐 경우
                    if (map[nextR][nextC] == 0) { // 검은 스카프의 끝일 경우
                        check++;	// 둘레 + 1
                    }
                }
            }
        }

        count += check;	// 총 둘레 + 둘레
    }

    // 경계선 체크
    private static boolean isPossibleToCheck(int r, int c) {
        if (r >= 0 && r < 100 && c >= 0 && c < 100) {
            return true;
        }
        return false;
    }
}
