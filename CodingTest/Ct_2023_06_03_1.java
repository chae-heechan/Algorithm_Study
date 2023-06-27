import java.util.*;

public class Ct_2023_06_03_1 {
    public static void main(String[] args) {
        PriorityQueue<Ct> pq = new PriorityQueue<>();

        ArrayList<Integer>[] arr = new ArrayList[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = new ArrayList<>();
        }

        Deque<Ct> dq = new LinkedList<>();

        pq.add(new Ct(1, "first"));
        pq.add(new Ct(2, "second"));

        System.out.println(pq.poll().name);
    }
}

class Ct implements Comparable<Ct>{
    long value;
    String name;

    @Override
    public int compareTo(Ct o) {
        return Long.valueOf(o.value - this.value).intValue();
    }

    public Ct(long value, String name) {
        this.value = value;
        this.name = name;
    }
}
