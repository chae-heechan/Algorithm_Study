package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18513 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = nk[0];
		int k = nk[1];

		Set<Long> visited = new HashSet<>();
		Queue<Home> q = new LinkedList<>();

		long[] waters = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

		for (long water : waters) {
			visited.add(water);
		}

		// 방문 배열에 확인 후
		// 큐에 샘터 옆자리 넣기
		for (long point : waters) {
			long left = point - 1;
			long right = point + 1;

			// 왼쪽 큐에 넣기
			if (!visited.contains(left)) {
				visited.add(left);
				q.add(new Home(left,1));
			}

			// 오른쪽 큐에 넣기
			if (!visited.contains(right)) {
				visited.add(right);
				q.add(new Home(right, 1));
			}
		}

		// 큐 돌면서 count 올리고 옆자리 방문 체크 후 큐에 넣기
		int count = 0;
		long unhappiness = 0;

		while(count < k) {
			count++;
			Home home = q.poll();
			unhappiness += home.unhappiness;

			Home leftHome = new Home(home.location-1, home.unhappiness+1);
			Home rightHome = new Home(home.location+1, home.unhappiness+1);

			// 왼쪽 큐에 넣기
			if (!visited.contains(leftHome.location)) {
				visited.add(leftHome.location);
				q.add(leftHome);
			}

			if (count >= k) {
				break;
			}

			// 오른쪽 큐에 넣기
			if (!visited.contains(rightHome.location)) {
				visited.add(rightHome.location);
				q.add(rightHome);
			}
		}

		System.out.println(unhappiness);
	}
}

class Home {
	public long location;
	public long unhappiness;

	Home(long location, long unhappiness) {
		this.location = location;
		this.unhappiness = unhappiness;
	}
}
