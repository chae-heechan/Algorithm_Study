package BeakJoon;

import java.util.Arrays;
import java.util.stream.Stream;

class ReserveSort {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int len = s.length();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = s.charAt(len - i - 1) - 48;
        }
        return answer;
    }
}