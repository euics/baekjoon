import java.io.*;
import java.util.*;

class Main {
	static ArrayList<ArrayList<Edge>> graph;
	static long[] dis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<Edge>());
		dis = new long[N + 1];
		Arrays.fill(dis, Long.MAX_VALUE);

		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph.get(A).add(new Edge(B, C));
		}

		boolean cycle = bellmanFord(N, 1);
		if (cycle)
			System.out.println(-1);
		else {
			for (int i = 2; i <= N; i++) {
				if (dis[i] == Long.MAX_VALUE)
					System.out.println(-1);
				else
					System.out.println(dis[i]);
			}
		}
	}

	public static boolean bellmanFord(int v, int src) {
		dis[src] = 0;

		for (int i = 1; i <= v - 1; i++) {
			for (int j = 1; j <= v; j++) {
				for (Edge o : graph.get(j)) {
					if (dis[j] != Long.MAX_VALUE && dis[o.v] > dis[j] + o.c)
						dis[o.v] = dis[j] + o.c;
				}
			}
		}

		for (int i = 1; i <= v; i++) {
			for (Edge o : graph.get(i)) {
				if (dis[i] != Long.MAX_VALUE && dis[o.v] > dis[i] + o.c)
					return true;
			}
		}

		return false;
	}
}

class Edge {
	int v, c;

	public Edge(int v, int c) {
		this.v = v;
		this.c = c;
	}
}