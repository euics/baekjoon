import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> positiveNum = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> negativeNum = new PriorityQueue<>();

		int answer = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());

			if (input > 1)
				positiveNum.add(input);
			else if (input == 1)
				answer += 1;
			else
				negativeNum.add(input);
		}

		while (!positiveNum.isEmpty() && positiveNum.size() >= 2)
			answer += positiveNum.poll() * positiveNum.poll();
		while (!positiveNum.isEmpty())
			answer += positiveNum.poll();

		while (!negativeNum.isEmpty() && negativeNum.size() >= 2)
			answer += negativeNum.poll() * negativeNum.poll();
		while (!negativeNum.isEmpty())
			answer += negativeNum.poll();

		System.out.println(answer);
	}
}