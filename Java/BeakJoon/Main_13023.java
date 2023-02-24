package BeakJoon;
/*
    1. friends라는 인접 리스트를 생성
    2. 연속 5명이 될때 까지 dfs(findFriends)를 돌며 탐색
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 골드 5
// ABCDE
public class Main_13023 {
    static List<Integer>[] friends; // 친구 관계 2차원 배열(인접 리스트)
    static boolean[] abcde; // 연속 친구
    static int n, m;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = nm[0];
        m = nm[1];

        friends = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            friends[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i ++) {
            int[] friendship = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            friends[friendship[0]].add(friendship[1]);
            friends[friendship[1]].add(friendship[0]);
        }

        // 한군데 들어가서 연속으로 방문 안한 곳 5개 가면 리턴 하는 함수
        for (int i = 0; i < n; i++) {
            abcde = new boolean[n];
            findFriends(i, 1);
        }

        System.out.println(answer);
    }


    // 연속으로 안겹치는 5명 찾을때 까지 탐색
    private static void findFriends(int index, int count) {
        // abcde에 있으면 리턴
        if (abcde[index]) {
            return;
        }

        // 없으면 추가
        abcde[index] = true;

        if (count == 5) {
            answer = 1;
            return;
        }

        //  friends[index].size만큼 돌면서 탐색
        for (int i = 0; i < friends[index].size(); i++) {
            findFriends(friends[index].get(i), count+1);
        }
        abcde[index] = false;
    }
}
