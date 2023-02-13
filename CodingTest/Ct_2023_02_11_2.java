
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