package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 플레티넘 5
// 찾기
public class Main_1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;

        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        int tLen = text.length;
        int pLen = pattern.length;

        int[] fail = new int[pLen];

        // 실패 테이블 생성
        for (int i = 1, j = 0; i < pLen; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = fail[j - 1];
            }
            if (pattern[i] == pattern[j]) fail[i] = ++j;
        }

        for (int i = 0 ,j = 0; i < tLen; i++) {
            // 현재 값과 패턴 값이 다를 경우
            while (j > 0 && text[i] != pattern[j]) {
                j = fail[j-1];  // 하나 이전 실패 테이블의 값으로 변경
            }
            // 현재 값과 패턴 값이 같을 경우
            if(text[i] == pattern[j]) {
                if(j == pLen - 1) {
                    count++;
                    j = fail[j];
                    sb.append(i - pLen + 2).append(" ");
                }else {
                    j++;
                }
            }
        }
        System.out.println(count);
        System.out.print(sb);
    }
}
