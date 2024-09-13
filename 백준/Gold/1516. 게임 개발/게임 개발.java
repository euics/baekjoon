import java.io.*;
import java.util.*;

class Main {
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) graph.add(new ArrayList<Integer>());
		int[] inDegree = new int[N + 1];
		int[] costs = new int[N + 1];
		int[] results = new int[N + 1];

		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			costs[i] = Integer.parseInt(st.nextToken());
			results[i] = costs[i];

			while (true) {
				int input = Integer.parseInt(st.nextToken());
				if(input == -1) break;

				graph.get(input).add(i);
				inDegree[i]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) q.add(i);
		}

		while (!q.isEmpty()) {
			int prev = q.poll();

			for(int next : graph.get(prev)) {
				inDegree[next]--;
				results[next] = Math.max(results[next], results[prev] + costs[next]);
				if(inDegree[next] == 0) q.add(next);
			}
		}

		for(int i = 1; i <= N; i++)
			System.out.println(results[i]);
	}
}