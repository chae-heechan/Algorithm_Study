package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] QUACK = {'q', 'u', 'a', 'c', 'k'};
        int index = 0;
        int answer = 0;

        String str = br.readLine();     // 입력 받은 후 길이가 5의 배수가 아닐 경우 끝
        if (str.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        ArrayList<Character> chars = new ArrayList<>();     // 입력 Character ArrayList로 바꾸기
        for (char c : str.toCharArray() ){
            chars.add(c);
        }

        int i = 0;      // 전체 index
        int prevLength = chars.size();  // 문자열의 이전 크기

        while(chars.size() > 0) {   // 길이 0될때 까지
            if (chars.get(i) == QUACK[index]) {     // 입력 받으며 quack순으로 비교
                index++;
                if (index == 5) index = 0;
                chars.remove(i);
            }
            else {  // 일치하지 않으면 다음 인덱스
                i++;
            }

            if (chars.size() <= i) {    // 끝까지 돌았을 경우
                i = 0;
                index = 0;
                answer++;

                if (prevLength / 5 == chars.size() / 5) {   // 이전 크기와 같을 경우
                    System.out.println(-1);
                    return;
                }

                prevLength = chars.size();
            }

        }

        System.out.println(answer);

    }
}