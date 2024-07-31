import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());
		int[] inDegree = new int[N + 1];
		int[] costs = new int[N + 1];
		int[] result = new int[N + 1]; // 각 건물의 완성 시간을 저장할 배열
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			costs[i] = Integer.parseInt(st.nextToken());

			while (true) {
				int building = Integer.parseInt(st.nextToken());
				if (building == -1)
					break;

				graph.get(building).add(i);
				inDegree[i]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
				result[i] = costs[i];
			}
		}

		while (!q.isEmpty()) {
			int prev = q.poll();

			for (int next : graph.get(prev)) {
				inDegree[next]--;
				result[next] = Math.max(result[next], result[prev] + costs[next]);
				if (inDegree[next] == 0)
					q.add(next);
			}
		}

		for (int i = 1; i <= N; i++)
			System.out.println(result[i]);
	}
}
