package Programmers;

import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Collections;

class IntReverseSort {
    public long solution(long n) {
        long answer = 0;

        String s = Long.toString(n);
        Integer[] ia = Stream.of(s.split("")).map(Integer::parseInt).toArray(Integer[]::new);

        Arrays.sort(ia);

        Arrays.sort(ia, Collections.reverseOrder());

        String result = Arrays.toString(ia).replaceAll("[^0-9]", "");

        answer = Long.valueOf(result);

        return answer;
    }
}