package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 골드 3
// 시간 여행
public class Main_6051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<ArrayList<Integer>> problemList = new ArrayList<ArrayList<Integer>>();
        problemList.add(new ArrayList<>(1));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if (command.equals("a")) {
                int problemNumber = Integer.parseInt(st.nextToken());
                List<Integer> newList = new ArrayList<>();
                newList.addAll(problemList.get(problemList.size() - 1));

                newList.add(problemNumber);
                problemList.add((ArrayList) newList);
                sb.append(newList.get(newList.size() - 1)).append("\n");
            } else if (command.equals("s")) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(problemList.get(problemList.size() - 1));

                // 값이 있으면 가장 마지막 값 삭제
                if (!newList.isEmpty()) {
                    newList.remove(newList.size() - 1);
                }

                // 문제 목록에 추가
                problemList.add((ArrayList) newList);

                // 값이 비어있으면 -1 출력
                if (newList.isEmpty()) {
                    sb.append(-1).append("\n");
                }else {
                    sb.append(newList.get(newList.size() - 1)).append("\n");
                }
            } else if (command.equals("t")) {
                int queryNumber = Integer.parseInt(st.nextToken());
                List<Integer> newList = new ArrayList<>();
                newList.addAll(problemList.get(queryNumber - 1));
                problemList.add((ArrayList) newList);

                // 값이 비어있으면 -1 출력
                if (newList.isEmpty()) {
                    sb.append(-1).append("\n");
                }else {
                    sb.append(newList.get(newList.size() - 1)).append("\n");
                }
            }

        }

        System.out.println(sb);


    }
}
