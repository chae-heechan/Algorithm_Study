package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();    // 가지고 있는 카드
        int m = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();    // 출력해야 하는 카드

        for (int key : A) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int key : B) {
            sb.append(map.getOrDefault(key, 0)).append(" ");
        }

        System.out.print(sb);
    }
}
