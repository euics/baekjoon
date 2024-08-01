import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<ArrayList<Edge>> graph;
	public static long[] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = 1;

		init(V);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int des = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(src).add(new Edge(des, cost));
		}

		boolean cycle = bellmanFord(V, 1);
		if (!cycle)
			System.out.println(-1);
		else {
			for (int i = 1; i <= V; i++) {
				if (i == start)
					continue;

				if (dis[i] == Long.MAX_VALUE)
					System.out.println(-1);
				else
					System.out.println(dis[i]);
			}
		}
	}

	public static void init(int V) {
		dis = new long[V + 1];
		Arrays.fill(dis, Long.MAX_VALUE);

		graph = new ArrayList<>();
		for (int i = 0; i <= V; i++)
			graph.add(new ArrayList<Edge>());
	}

	public static boolean bellmanFord(int V, int src) {
		dis[src] = 0;

		// 벨만포드 알고리즘
		for (int i = 1; i <= V - 1; i++) {
			for (int j = 1; j <= V; j++) {
				for (Edge o : graph.get(j)) {
					if (dis[j] != Long.MAX_VALUE && dis[o.v] > o.c + dis[j])
						dis[o.v] = o.c + dis[j];
				}
			}
		}

		// 음의 사이클 검사
		for (int i = 1; i <= V; i++) {
			for (Edge o : graph.get(i)) {
				if (dis[i] != Long.MAX_VALUE && dis[o.v] > o.c + dis[i])
					return false;
			}
		}

		return true;
	}
}

class Edge {
	int v, c;

	public Edge(int v, int c) {
		this.v = v;
		this.c = c;
	}
}