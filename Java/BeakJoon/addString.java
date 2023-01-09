import java.util.*;

public class addString {
    public int solution(int n) {
        int answer = 0;
        String num = String.valueOf(n);
        for (int i = 0; i < num.length(); i++) {
            answer += Character.getNumericValue(num.charAt(i));
        }
        return answer;
    }
}