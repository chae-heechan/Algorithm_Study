package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// D4
// 최소 스패닝 트리
public class Solution_3124 {
    static int v, e;
    static int[] parents;
    static Long answer;
    static Long count;
    static Edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            sb.append("#").append(t).append(" ");
            int[] ve = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            v = ve[0];
            e = ve[1];

            makeSet();
            edges = new Edge[e];
            for (int i = 0; i < e; i++) {
                int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                edges[i] = new Edge(data[0], data[1], data[2]);
            }
            Arrays.sort(edges);

            answer = 0l;
            count = 0l;

            for (Edge edge : edges) {
                if (union(edge.from, edge.to)) {
                    answer += edge.weight;
                    if (++count > v-1) break;
                }
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);
    }

    private static void makeSet() {
        parents = new int[v+1];
        for (int i = 0; i < v; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findSet(parents[x]);
    }

    private static boolean union(int x, int y) {
        int a = findSet(x);
        int b = findSet(y);

        if (a == b) return false;
        parents[b] = a;
        return true;
    }
}

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
