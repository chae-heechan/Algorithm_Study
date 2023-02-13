package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

// D3
// 암호문 1
public class Solution_1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());

            LinkedList<Integer> list = new LinkedList<>();

            for (int data : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
                list.add(data);
            }

            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                st.nextToken();  // i 날리기
                int index = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());

                for (int j = 0; j < count; j++) {
                    list.add(index+j, Integer.parseInt(st.nextToken()));
                }
            }

            sb.append("#").append(t).append(" ");

            for (int i = 0; i < 10; i++){
                sb.append(list.get(i)).append(" ");
            }

            System.out.println(sb);
            sb.setLength(0);

        }
    }
}
