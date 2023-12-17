package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main_1235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> arr = new ArrayList<>();
		HashSet<String> set = new HashSet<>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			arr.add(str);
		}

		int length = arr.get(0).length();

		int currentLength = 1;

		while (true) {
			for (int i = 0; i < n; i++) {
				String str = arr.get(i);
				str = str.substring(length-currentLength, length);
				set.add(str);
			}

			if (set.size() != n) {
				set.clear();
				currentLength++;
				continue;
			}

			break;

		}

		System.out.println(currentLength);
	}
}
