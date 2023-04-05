package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2671 {
    static String sound;
    static int i;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sound = br.readLine();

        if (sound.charAt(i) == '1') startWithOne();
        else startWithZero();

        if (i == sound.length()) System.out.print("SUBMARINE");
        else System.out.print("NOISE");
    }

    private static void startWithOne() {
        if (!isPossible(++i)) {
            i--;
            return;
        }
        char c = sound.charAt(i);
        int count = 0;
        while (c != '1') {
            count++;
            if (!isPossible(++i)) {
                i--;
                return;
            }
            c = sound.charAt(i);
        }
        if (count < 2) {
            i--;
            return;
        }

        while (c!= '0') {
            if (!isPossible(++i)) {
                return;
            }
            c = sound.charAt(i);
        }
        if (sound.charAt(i+1) == '0') {
            i--;
            startWithOne();
        }
        else startWithZero();

    }

    private static void startWithZero() {
        if (!isPossible(++i)) {
            i--;
            return;
        }
        char c = sound.charAt(i);
        if (c == '0') {
            i--;
            return;
        }

        if (!isPossible(++i)) return;
        if (sound.charAt(i) == '1') startWithOne();
        else startWithZero();
    }


    private static boolean isPossible(int x) {
        if (x >= sound.length()) {
            return false;
        }
        return true;
    }
}
