import java.io.*;
import java.util.*;

class Main {
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<Integer>());
		int[] inDegree = new int[N + 1];
		int[] costs = new int[N + 1];
		int[] results = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			costs[i] = Integer.parseInt(st.nextToken());

			while (true) {
				int pre = Integer.parseInt(st.nextToken());
				if (pre == -1)
					break;

				graph.get(pre).add(i);
				inDegree[i]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
				results[i] = costs[i];
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : graph.get(cur)) {
				inDegree[next]--;
				results[next] = Math.max(results[next], results[cur] + costs[next]);
				if (inDegree[next] == 0)
					q.add(next);
			}
		}

		for(int i = 1; i <= N; i++)
			System.out.println(results[i]);
	}
}