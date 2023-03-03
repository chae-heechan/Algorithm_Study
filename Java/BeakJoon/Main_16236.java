package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 골드 3
// 아기 상어
public class Main_16236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] map;
    static int n;
    static int x, y;    // 현재 상어 위치
    static int time;    // 이동 시간
    static int size = 2;    // 상어 사이즈
    static int exp;     // 상어 경험치
    static boolean check;

    static Queue<Point> tempQ = new LinkedList<>();
    static PriorityQueue<Point> q;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {


        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 9) {   // 상어 위치 저장
                    x = i;
                    y = j;
                    map[i][j] = 0;
                }
            }
        }

        

        while (true) {
            tempQ = new LinkedList<>();     // 임시 큐 초기화
            q = new PriorityQueue<>();     // 큐와 visited 초기화
            visited = new boolean[n][n];
            
            q.offer(new Point(x, y, n));   // 큐와 vsitied에 현재위치 추가
            visited[x][y] = true;
            
            findFish();

            if (check){
                System.out.println(time);
                return;
            }
        }

    }

    private static void findFish() {
        int[] dr = {-1, 0, 0, 1};  // 상, 좌, 우, 하
        int[] dc = {0, -1, 1, 0};
        int distance = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();

            // q size 만큼 돌면서 찾고 없으면 거리 + 1
            for (int i = 0; i < qSize; i++) {
                Point data = q.poll();
                int r = data.r;
                int c = data.c;

                if (map[r][c] != 0 && map[r][c] < size) {     // 상어가 먹을 수 있을 경우
                    x = r;  // 상어 위치 이동
                    y = c;
                    map[x][y] = 0;  // 이동한 위치 0으로 만들기
                    time += distance;   // 이동 시간 증가

                    if (++exp == size) {
                        exp = 0;
                        size++;
                    }

                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nextR = r + dr[d];
                    int nextC = c + dc[d];

                    if (isPossible(nextR, nextC)) {
                        visited[nextR][nextC] = true;
                        // 바로 넣으면 안되고 (temp에 넣어뒀다가) 한바퀴 끝나고 넣어야함
                        tempQ.offer(new Point(nextR, nextC, n));
                    }
                }
            }

            // 한바퀴 끝나고 pq에 넣기
            while (!tempQ.isEmpty()) {
                q.offer(tempQ.poll());
            }

            // 거리 추가
            distance++;
        }
        check = true;

    }

    // 이동 가능한지 확인
    private static boolean isPossible(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && map[x][y] <= size) {
            return true;
        }
        return false;
    }
}

class Point implements Comparable<Point>{
    int index;
    int r;
    int c;

    public Point(int r, int c, int n) {
        this.r = r;
        this.c = c;
        this.index = r * n + c;
    }

    @Override
    public int compareTo(Point o) {
        return this.index - o.index;
    }
}
