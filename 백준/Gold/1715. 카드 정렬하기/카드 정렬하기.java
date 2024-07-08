import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++)
			pq.add(Integer.parseInt(br.readLine()));

		int answer = 0;
		while (!pq.isEmpty() && pq.size() >= 2) {
			int a = pq.poll();
			int b = pq.poll();

			answer += (a + b);
			pq.add(a + b);
		}

		System.out.println(answer);
	}
}