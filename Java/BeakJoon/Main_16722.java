package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 골드 4
// 결합
public class Main_16722 {
    static String[][] table = new String[10][3];
    static List<Integer> hList = new ArrayList<>();
    static int point;
    static boolean gFlag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 9; i++) {
            table[i] = br.readLine().split(" ");
        }

        for (int i = 1; i <= 7; i++) {
            for (int j = i+1; j <= 8; j++) {
                for (int k = j+1; k <= 9; k++) {
                    checkG(i, j, k);
                }
            }
        }

        int n = Integer.parseInt(br.readLine());

        String command;
        for (int c = 0; c < n; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            // 결일 경우
            if (command.equals("G")) {
                if (hList.size() == 0 && !gFlag) {
                    gFlag = true;
                    point += 3;
                }else {
                    point -= 1;
                }
            }else if (command.equals("H")){ // 합일 경우
                PriorityQueue<Integer> tempL = new PriorityQueue<>();
                tempL.add(Integer.parseInt(st.nextToken()));
                tempL.add(Integer.parseInt(st.nextToken()));
                tempL.add(Integer.parseInt(st.nextToken()));

                int tempN = 0;
                tempN += tempL.poll() * 100;
                tempN += tempL.poll() * 10;
                tempN += tempL.poll();

                if (hList.contains(tempN)) {
                    point += 1;
                    hList.remove(Integer.valueOf(tempN));
                } else {
                    point -= 1;
                }
            }

        }

        System.out.println(point);

    }

    private static void checkG(int i, int j, int k) {
        // 도형 모양
        if (!table[i][0].equals(table[j][0]) && !table[j][0].equals(table[k][0])
            && !table[i][0].equals(table[k][0])) {
            // 다 다름
        } else if (table[i][0].equals(table[j][0]) && table[j][0].equals(table[k][0])) {
            // 다 같음
        } else {
            return;
        }

        // 도형 색상
        if (!table[i][1].equals(table[j][1]) && !table[j][1].equals(table[k][1])
                && !table[i][1].equals(table[k][1])) {
            // 다 다름
        } else if (table[i][1].equals(table[j][1]) && table[j][1].equals(table[k][1])) {
            // 다 같음
        } else {
            return;
        }

        // 배경 색상
        if (!table[i][2].equals(table[j][2]) && !table[j][2].equals(table[k][2])
                && !table[i][2].equals(table[k][2])) {
            // 다 다름
        } else if (table[i][2].equals(table[j][2]) && table[j][2].equals(table[k][2])) {
            // 다 같음
        } else {
            return;
        }

        hList.add(i*100 + j*10 + k);
    }
}
