import java.io.*;
import java.util.*;

class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i < N; i++)
			graph.add(new ArrayList<Integer>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		for (int i = 0; i < N; i++) {
			if (!flag)
				DFS(0, i, new boolean[N]);
		}
		System.out.println(flag ? 1 : 0);
	}

	public static void DFS(int L, int node, boolean[] bool) {
		bool[node] = true;

		if (L == 4) {
			flag = true;

			return;
		}

		for (int edge : graph.get(node)) {
			if (!bool[edge]) {
				bool[edge] = true;
				DFS(L + 1, edge, bool);
				bool[edge] = false;
			}
		}
	}
}