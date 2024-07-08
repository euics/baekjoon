import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		int answer = 0, endTime = 0;
		while (!pq.isEmpty()) {
			while (!pq.isEmpty() && endTime > pq.peek()[0])
				pq.poll();

			while (!pq.isEmpty() && endTime <= pq.peek()[0]) {
				endTime = pq.peek()[1];
				pq.poll();
				answer++;
			}
		}

		System.out.println(answer);
	}
}