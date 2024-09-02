import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++)
			pq.add(Integer.parseInt(br.readLine()));

		int answer = 0;
		while (!pq.isEmpty() && pq.size() >= 2) {
			int sum = pq.poll() + pq.poll();
			answer += sum;
			pq.add(sum);
		}

		System.out.println(answer);
	}
}