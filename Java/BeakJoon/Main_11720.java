package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        System.out.println(sum);
    }
}
