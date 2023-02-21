package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_6987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 4; tc++) {
            int check = 1;
            st = new StringTokenizer(br.readLine());
            int[][] teams = new int[6][4];

            // 승무패 저장
            for (int team = 0; team < 6; team++) {
                teams[team][0] = Integer.parseInt(st.nextToken());
                teams[team][1] = Integer.parseInt(st.nextToken());
                teams[team][2] = Integer.parseInt(st.nextToken());

                if (teams[team][0] + teams[team][1] + teams[team][2] != 5) check = 0;

                teams[team][3] = team;
            }

            // 승이 많은 팀 순으로 정렬
            Arrays.sort(teams, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });

            int[][] winsTeams = Arrays.copyOf(teams, teams.length);

            // 패가 많은 팀 순으로 정렬
            Arrays.sort(teams, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[2] - o1[2];
                }
            });

            // 승패 체크
            for (int i = 0; i < 6; i++) {
                if (check == 0) break;
                for (int w = 0; w < winsTeams[i][0]; w++) {
                    if (teams[w][3] != winsTeams[w][3]) {   // 다른팀일 경우
                        if (teams[w][3] == 0){  // 해당팀의 패가 0일 경우
                            check = 0;
                            break;
                        }
                        teams[w][2]--;
                    }else { // 같은 팀일 경우
                        w++;
                    }
                }
            }

            for (int i = 0; i < 6; i++) {
                if (teams[i][2] != 0){
                    check = 0;
                    break;
                }
            }

            // 무 체크
            int dCount = 0;
            int dToggle = 1;
            int dTeamCount = 0;
            int dMax = 0;

            for (int i = 0; i < 6; i++) {
                if (teams[i][1] != 0) { // 무승부가 있으면
                    dCount += teams[i][1] * dToggle;
                    dTeamCount++;

                    if (dToggle > 0) dToggle = -1;
                    else dToggle = 1;

                    dMax = Math.max(dMax, teams[i][1]);
                }
            }

            if (dMax != 0 && !(dMax < dTeamCount)) {
                check = 0;
            }

            if (dCount != 0) {
                check = 0;
            }

            sb.append(check).append(" ");

        }

        System.out.println(sb);
    }
}
