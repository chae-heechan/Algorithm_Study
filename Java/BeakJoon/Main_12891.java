package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 실버 2
// DNA 비밀번호
public class Main_12891 {
    static int s;
    static int p;
    static int[] count = {0, 0, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] sp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        s = sp[0];
        p = sp[1];

        String pw = br.readLine();

        // 길이만큼 for문 돌면서 배열에 카운트해 넣는다
        for (int i = 0; i < p; i++) {
            switch (pw.charAt(i)){
                case 'A':
                    count[0]++;
                    break;
                case 'C':
                    count[1]++;
                    break;
                case 'G':
                    count[2]++;
                    break;
                case 'T':
                    count[3]++;
                    break;
            }
        }

        int[] acgt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 현재 값이 조건에 맞을 경우
        if (count[0] >= acgt[0] && count[1] >= acgt[1] &&
                count[2] >= acgt[2] && count[3] >= acgt[3])
        {
            answer++;
        }

        // 다음은 길이만큼 돌면서 시작부분 char가 acgt면 해당 카운트 빼고
        // 끝 부분에 들어온 char가 acgt면 해당 카운트 추가

        for(int start = 0, end = p; end < s; start++, end++){

            // 시작값 빼ㄱㅣ
            switch (pw.charAt(start)){
                case 'A':
                    count[0]--;
                    break;
                case 'C':
                    count[1]--;
                    break;
                case 'G':
                    count[2]--;
                    break;
                case 'T':
                    count[3]--;
                    break;
            }

            // 끝값 더하기
            switch (pw.charAt(end)){
                case 'A':
                    count[0]++;
                    break;
                case 'C':
                    count[1]++;
                    break;
                case 'G':
                    count[2]++;
                    break;
                case 'T':
                    count[3]++;
                    break;
            }

            // 조건이 맞을 경우
            if (count[0] >= acgt[0] && count[1] >= acgt[1] &&
                    count[2] >= acgt[2] && count[3] >= acgt[3])
            {
                answer++;
            }
        }


        System.out.println(answer);


    }
}
