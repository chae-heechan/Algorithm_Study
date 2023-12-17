package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1461 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        for (int number : numbers) {
            if (0 < number) {
                plus.add(number);
            } else {
                minus.add(number);
            }
        }

        Collections.sort(plus);
        Collections.sort(minus);

        for (int i = 0; i < minus.size(); i = i + m) {
            answer -= minus.get(i) * 2;
        }

        for (int i = plus.size()-1; i >= 0; i = i - m) {
            answer += plus.get(i) * 2;
        }

        if ((minus.size() == 0) || (plus.size() == 0)) {
            if (minus.size() == 0) {
                answer -= plus.get(plus.size()-1);
            } else {
                answer += minus.get(0);
            }
        } else {
            if ((minus.get(0) + plus.get(plus.size() - 1)) >= 0) {
                answer -= plus.get(plus.size() - 1);
            } else {
                answer += minus.get(0);
            }
        }

        System.out.println(answer);

    }
}