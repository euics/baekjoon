import java.util.*;
import java.io.*;

public class Main {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int answer = 0;
		while (pq.size() >= 2) {
			int min = pq.poll();
			int max = pq.poll();
			answer += min + max;

			pq.add(min + max);
		}

		System.out.println(answer);
	}
}