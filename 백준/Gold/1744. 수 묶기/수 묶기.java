import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());

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

		while (!positiveNum.isEmpty() && positiveNum.size() > 1)
			answer += (positiveNum.poll() * positiveNum.poll());
		if (!positiveNum.isEmpty())
			answer += positiveNum.poll();

		while (!negativeNum.isEmpty() && negativeNum.size() > 1)
			answer += (negativeNum.poll() * negativeNum.poll());
		if (!negativeNum.isEmpty())
			answer += negativeNum.poll();

		System.out.println(answer);
	}
}