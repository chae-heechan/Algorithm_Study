package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        String[] lights = input.clone();
        String[] goal = br.readLine().split("");


        int count = 0;

        // 첫번째 스위치 누르지 않기
        for (int i = 0; i < lights.length - 2; i++) {
            if (!lights[i].equals(goal[i])) {
                count++;
                if (lights[i].equals("0")) {
                    lights[i] = "1";
                } else {
                    lights[i] = "0";
                }

                if (lights[i+1].equals("0")) {
                    lights[i+1] = "1";
                } else {
                    lights[i+1] = "0";
                }

                if (lights[i+2].equals("0")) {
                    lights[i+2] = "1";
                } else {
                    lights[i+2] = "0";
                }
            }
        }

        if (Arrays.toString(lights).equals(Arrays.toString(goal))) {
            System.out.println(count);
            return;
        }

        // 마지막 스위치 누르기
        if (lights[lights.length-2].equals("0")) {
            lights[lights.length-2] = "1";
        } else {
            lights[lights.length-2] = "0";
        }

        if (lights[lights.length-1].equals("0")) {
            lights[lights.length-1] = "1";
        } else {
            lights[lights.length-1] = "0";
        }
        if (Arrays.toString(lights).equals(Arrays.toString(goal))) {
            System.out.println(++count);
            return;
        }

        // 카운트 초기화 및 첫번째 스위치 누르기
        lights = input.clone();
        count = 1;
        if (lights[0].equals("0")) {
            lights[0] = "1";
        } else {
            lights[0] = "0";
        }

        if (lights[1].equals("0")) {
            lights[1] = "1";
        } else {
            lights[1] = "0";
        }

        for (int i = 0; i < lights.length - 2; i++) {
            if (!lights[i].equals(goal[i])) {
                count++;
                if (lights[i].equals("0")) {
                    lights[i] = "1";
                } else {
                    lights[i] = "0";
                }

                if (lights[i+1].equals("0")) {
                    lights[i+1] = "1";
                } else {
                    lights[i+1] = "0";
                }

                if (lights[i+2].equals("0")) {
                    lights[i+2] = "1";
                } else {
                    lights[i+2] = "0";
                }
            }
        }

        if (Arrays.toString(lights).equals(Arrays.toString(goal))) {
            System.out.println(count);
            return;
        }

        // 마지막 스위치 누르기
        if (lights[lights.length-2].equals("0")) {
            lights[lights.length-2] = "1";
        } else {
            lights[lights.length-2] = "0";
        }

        if (lights[lights.length-1].equals("0")) {
            lights[lights.length-1] = "1";
        } else {
            lights[lights.length-1] = "0";
        }
        if (Arrays.toString(lights).equals(Arrays.toString(goal))) {
            System.out.println(++count);
            return;
        }

        System.out.println(-1);

    }
}
