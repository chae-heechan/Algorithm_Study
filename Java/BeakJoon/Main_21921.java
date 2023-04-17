package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 실버 3
// 블로그
public class Main_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxVisited = 0, currentVisited = 0, maxCount = 1;
        int n, x;
        int[] visited;

        int[] nx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = nx[0];
        x = nx[1];

        for (int i = 0; i < x; i++){
            currentVisited += visited[i];
        }
        maxVisited = currentVisited;

        for (int j = 0, i = x; i < n; i++, j++) {
            currentVisited += visited[i];
            currentVisited -= visited[j];
            if (maxVisited < currentVisited) {
                maxVisited = currentVisited;
                maxCount = 1;
            } else if (maxVisited == currentVisited) {
                maxCount++;
            }
        }

        if (maxVisited == 0) {
            System.out.println("SAD");
        } else{
            System.out.println(maxVisited);
            System.out.println(maxCount);
        }

    }
}
