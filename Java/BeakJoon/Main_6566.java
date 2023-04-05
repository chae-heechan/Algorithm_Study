package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_6566 {
    static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input;
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String>[] arr = new ArrayList[30000];
        for (int i = 0; i < 30000; i++) {
            arr[i] = new ArrayList<>();
        }
        // map에 정렬한 이름 : 인덱스 이렇게 저장
        // map에 있으면 index 리턴해서 그 index에 배열에 넣기 없어도 똑같이
        // 마지막에 배열 크기 순으로 정렬 위 5개 뽑기

        while ((input = br.readLine()) != null) {
//        for (int i = 0; i < 16; i++) {
            input = br.readLine();
            int value = 0;
            char[] chars = input.toCharArray();
            Arrays.sort(chars);
            String str = Arrays.toString(chars);

            if (map.containsKey(str)) {
                value = map.get(str);
            } else {
                map.put(str, count);
                value = count++;
            }

            if (!arr[value].contains(input))
                arr[value].add(input);
        }

        Arrays.sort(arr, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                if (o1.size() == o2.size() && o1.size() != 0) return o1.get(0).compareTo(o2.get(0));
                return o2.size() - o1.size();
            }
        });
//        Arrays.sort(arr, (ArrayList<String> a1, ArrayList<String> a2) -> a2.size() - a1.size());

        for (int i =0; i < 5; i++) {
            if (arr[i].size() == 0) return;
            System.out.printf("Group of Size %d: ", arr[i].size());
            Collections.sort(arr[i]);
            for (String s : arr[i]) {
                System.out.printf("%s ",s);
            }
            System.out.println(".");
        }

    }

}
