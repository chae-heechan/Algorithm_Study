package BeakJoon;

class Ct1 {
    public static void main(String[] args) {
        String a = "aaa";
        char[] c = a.toCharArray();

        System.out.println(c);
    }

    public int solution(int[][] lotteries) {
        double[] rate = new double[lotteries.length];
        double max_rate = 0.0;
        int max_price = 0;
        int max_index = 0;

        for (int i = 0; i < lotteries.length; i++) {

            rate[i] = (double)lotteries[i][0] / (double)(lotteries[i][1]+1) * 100.0;
            if ((int)rate[i] >= 100){
                rate[i] = 100.0;
            }

            if (max_rate < rate[i]){
                max_rate = rate[i];
                max_price = lotteries[i][2];
                max_index = i;
            }else if (max_rate == rate[i]){
                if (max_price < lotteries[i][2]){
                    max_rate = rate[i];
                    max_price = lotteries[i][2];
                    max_index = i;
                }
            }


        }

        return max_index+1;


    }
}

class Solution {
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    char[][] arr;
    int[][] visited;
    int count = 0;
    int x;
    int y;
    public int solution(String[] grid) {
        x = grid.length;
        y = grid[0].length();
        arr = new char[x][y];
        visited = new int[x][y];

        for(int i = 0; i < x; i++){
            arr[i] = grid[i].toCharArray();
        }

        System.out.println(arr[x-1][y-2]);

         for (int i = 0; i < x; i++){    // 왼쪽 줄
             dfs(i, 0);
         }
         for (int i = 0; i < x; i++){    // 오른쪽 줄
             dfs(i, y-1);
         }
         for (int i = 0; i < y; i++){    // 위쪽 줄
             dfs(0, i);
         }
         for (int i = 0; i < y; i++){    // 아래쪽 줄
             dfs(x-1, i);
         }

        System.out.println(count);

        return x*y - count;
    }

    public void dfs(int r, int c){

        if(visited[r][c] == 0 && arr[r][c] == '.'){
            System.out.println(r + " " + c);
            System.out.println(arr[r][c]);
            count++;
            visited[r][c] = 1;
            for (int i = 0; i < 4; i++){
                if(r+dr[i] >= 0 && r+dr[i] < x && c+dc[i] >= 0 && c+dc[i] < y){
                    dfs(r+dr[i], c+dc[i]);
                }
            }
        }
    }
}