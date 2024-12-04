import java.util.*;
import java.io.*;

public class Main {
	static int visited = 0;
	static int[] inDegree;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new LinkedList<>();
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

			int size = Integer.parseInt(st.nextToken());
			int[] tmp = new int[size];
			for (int j = 0; j < size; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < size - 1; j++) {
				graph.get(tmp[j]).add(tmp[j + 1]);
				inDegree[tmp[j + 1]]++;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append("\n");
			visited++;

			for (int next : graph.get(cur)) {
				inDegree[next]--;

				if (inDegree[next] == 0) {
					q.add(next);
				}
			}
		}

		if (visited != N) {
			System.out.println(0);
		} else {
			System.out.println(sb.toString());
		}
	}
}