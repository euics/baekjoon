import java.io.*;
import java.util.*;

class Main {
	static ArrayList<ArrayList<Edge>> graph;
	static int maxDistance = Integer.MIN_VALUE;
	static int maxNode = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<Edge>());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int edge = Integer.parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				int connectedEdge = Integer.parseInt(st.nextToken());
				if (connectedEdge != -1) {
					int distance = Integer.parseInt(st.nextToken());
					graph.get(edge).add(new Edge(connectedEdge, distance));
				}
			}
		}

		DFS(1, 0, new boolean[N + 1]);
		DFS(maxNode, 0, new boolean[N + 1]);

		System.out.println(maxDistance);
	}

	public static void DFS(int node, int distance, boolean[] bool) {
		bool[node] = true;

		if (maxDistance < distance) {
			maxDistance = distance;
			maxNode = node;
		}

		for (Edge edge : graph.get(node)) {
			if (!bool[edge.v]) {
				bool[edge.v] = true;
				DFS(edge.v, distance + edge.d, bool);
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int v, d;

	public Edge(int c, int d) {
		this.v = c;
		this.d = d;
	}

	@Override
	public int compareTo(Edge o) {
		return o.d - this.d;
	}
}