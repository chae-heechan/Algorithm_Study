package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_2608 {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arabicSum = 0;

        for (int t = 0; t < 2; t++) {
            String input = br.readLine();
            int inputLength = input.length();

            for (int i = 0; i < inputLength - 1; i++) {
                // 현재 값이 다음 값 보다 작을 경우
                if (roman.get(input.charAt(i)) < roman.get(input.charAt(i + 1))) {
                    arabicSum -= roman.get(input.charAt(i));
                }
                else {
                    arabicSum += roman.get(input.charAt(i));
                }
            }
            arabicSum += roman.get(input.charAt(inputLength - 1));    // 마지막 값 추가
        }

        System.out.println(arabicSum);

        // arabicToRoman

        StringBuilder romanSum = new StringBuilder();

        int temp = 0;

        // 분기문으로 나눠가면서 romanSum에 더하기
        while (arabicSum != 0) {
            if (arabicSum / 1000 != 0) {
                temp = arabicSum / 1000;
                while (temp-- != 0) {
                    romanSum.append("M");
                }
                arabicSum %= 1000;
            }
            else if (arabicSum / 100 != 0) {
                temp = arabicSum/100;
                if (temp == 9) romanSum.append("CM");
                else if (temp == 5) romanSum.append("D");
                else if (temp == 4) romanSum.append("CD");
                else if (temp > 5) {
                    romanSum.append("D");
                    temp -= 5;
                    while(temp-- != 0) romanSum.append("C");
                }
                else if (temp < 5) {
                    while(temp-- != 0) romanSum.append("C");
                }
                arabicSum %= 100;
            }
            else if (arabicSum / 10 != 0) {
                temp = arabicSum / 10;
                if (temp == 9) romanSum.append("XC");
                else if (temp == 5) romanSum.append("L");
                else if (temp == 4) romanSum.append("XL");
                else if (temp > 5) {
                    romanSum.append("L");
                    temp -= 5;
                    while(temp-- != 0) romanSum.append("X");
                }
                else if (temp < 5) {
                    while(temp-- != 0) romanSum.append("X");
                }
                arabicSum %= 10;
            }
            else {
                temp = arabicSum;
                if (temp == 9) romanSum.append("IX");
                else if (temp == 5) romanSum.append("V");
                else if (temp == 4) romanSum.append("IV");
                else if (temp > 5) {
                    romanSum.append("V");
                    temp -= 5;
                    while(temp-- != 0) romanSum.append("I");
                }
                else if (temp < 5) {
                    while(temp-- != 0) romanSum.append("I");
                }
                break;
            }
        }

        System.out.println(romanSum);
    }
}
