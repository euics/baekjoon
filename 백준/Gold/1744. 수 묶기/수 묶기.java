import java.util.*;
import java.io.*;

public class Main {
	static int ones = 0, answer = 0;
	static ArrayList<Integer> positive = new ArrayList<>();
	static ArrayList<Integer> negative = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());

			if (input > 1) {
				positive.add(input);
			} else if (input == 1) {
				ones++;
			} else {
				negative.add(input);
			}
		}

		Collections.sort(positive, Collections.reverseOrder());
		Collections.sort(negative);

		for (int i = 0; i < positive.size(); i++) {
			if (i + 1 < positive.size()) {
				answer += positive.get(i) * positive.get(i + 1);
				i++;
			} else {
				answer += positive.get(i);
			}
		}

		for (int i = 0; i < negative.size(); i++) {
			if (i + 1 < negative.size()) {
				answer += negative.get(i) * negative.get(i + 1);
				i++;
			} else {
				answer += negative.get(i);
			}
		}

		answer += ones;
		System.out.println(answer);
	}
}

/*
 3 2 1 -1

 5 4 3 1 0 -1 -2

 5 4 1 0 -1 -2

 20 26
*/