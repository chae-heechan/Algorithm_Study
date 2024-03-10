import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Ct_2024_02_04_test_2 {
    public static void main(String[] args) {
        int[] B = {3, 3, 3, 2, 2, 1};
        int[] A = {3, 3, 2, 4, 5};

        ArrayList<Integer> result = findDuplicates(A, B);

        // 출력
        System.out.println(result);
    }

    public static ArrayList<Integer> findDuplicates(int[] A, int[] B) {
        HashMap<Integer, Integer> countMapA = new HashMap<>();
        HashMap<Integer, Integer> countMapB = new HashMap<>();

        // A 배열의 숫자 등장 횟수 기록
        for (int num : A) {
            countMapA.put(num, countMapA.getOrDefault(num, 0) + 1);
        }



        // B 배열의 숫자 등장 횟수 기록
        for (int num : B) {
            countMapB.put(num, countMapB.getOrDefault(num, 0) + 1);
        }

        // 중복된 숫자 찾기
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : countMapA.keySet()) {
            int countInA = countMapA.getOrDefault(num, 0);
            int countInB = countMapB.getOrDefault(num, 0);

            int commonCount = Math.min(countInA, countInB);

            for (int i = 0; i < commonCount; i++) {
                result.add(num);
            }
        }

        return result;
    }
}