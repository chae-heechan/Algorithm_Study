import java.math.BigDecimal;
import java.util.Scanner;

class Main_1914 {
  static StringBuffer bf = new StringBuffer();

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.close();
    BigDecimal d = new BigDecimal("2").pow(N).subtract(BigDecimal.ONE);
    bf.append(d + "\n");

    if (N <= 20) {
      hanoi(N, 1, 2, 3);
    }

    System.out.println(bf.toString());

  }

  public static void hanoi(int N, int from, int temp, int to) {

    if (N == 1) {
      bf.append(from + " " + to + "\n");
      return;
    }

    // 위에있는 층들 temp로 이동
    hanoi(N - 1, from, to, temp);

    // 가장 아래 층 to로 이동
    bf.append(from + " " + to + "\n");

    // temp에 있는 층들 to로 이동
    hanoi(N - 1, temp, from, to);
  }
}