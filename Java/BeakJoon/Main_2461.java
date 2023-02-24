package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 골드 2
// 대표 선수
public class Main_2461 {
    static int n, m;
    static int max = 0, min = Integer.MAX_VALUE;
    static int answer;

    static int[] estudiantes;
    static PriorityQueue<Estudiante> pq = new PriorityQueue<>(new Comparator<Estudiante>() {
        @Override
        public int compare(Estudiante o1, Estudiante o2) {
            return o2.punto - o1.punto;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = nm[0];
        m = nm[1];

        estudiantes = new int[n];

        // 우선순위 큐에 학생을 점수, 반 으로 점수 큰 순으로 정렬
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            // estudiantes의 모든반에 학생 점수 채워주기
            int point = Integer.parseInt(st.nextToken());
            estudiantes[i] = point;
            pq.offer(new Estudiante(i, point));

            if (max < point) max = point;
            if (min > point) min = point;
            answer = max - min;

            for (int j = 1;j < m; j++) {
                pq.offer(new Estudiante(i, Integer.parseInt(st.nextToken())));
            }
        }

        while (!pq.isEmpty()) {
            Estudiante es = pq.poll();

            //
            estudiantes[es.clase] = es.clase;
            if (max < es.punto) max = es.punto;
            if (min > es.punto) min = es.punto;
            answer = max - min;

        }

    }
}

class Estudiante {
    int clase;
    int punto;

    public Estudiante(int clase, int punto) {
        this.clase = clase;
        this.punto = punto;
    }
}