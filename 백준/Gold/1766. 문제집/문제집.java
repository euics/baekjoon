import java.util.*;
import java.io.*;

public class Main {
	static int[] inDegree;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		inDegree = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(A).add(B);
			inDegree[B]++;
		}

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				pq.add(i);
			}
		}

		while (!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur).append(" ");

			for (int next : graph.get(cur)) {
				inDegree[next]--;

				if (inDegree[next] == 0) {
					pq.add(next);
				}
			}
		}

		System.out.println(sb.toString());
	}
}