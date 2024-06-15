import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		int[] answer = new int[sources.length];

		init(n, roads);
		dis = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);

		dijkstra(destination);

		for (int i = 0; i < sources.length; i++) {
			if (dis[sources[i]] == Integer.MAX_VALUE)
				answer[i] = -1;
			else
				answer[i] = dis[sources[i]];
		}

		return answer;
	}

	public void init(int n, int[][] roads) {
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			graph.add(new ArrayList<Edge>());
		for (int[] road : roads) {
			int v1 = road[0];
			int v2 = road[1];

			graph.get(v1).add(new Edge(v2, 1));
			graph.get(v2).add(new Edge(v1, 1));
		}
	}

	public void dijkstra(int source) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.c - b.c);
		pq.add(new Edge(source, 0));
		dis[source] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (dis[cur.v] < cur.c)
				continue;

			for (Edge o : graph.get(cur.v)) {
				if (dis[o.v] > cur.c + o.c) {
					pq.add(new Edge(o.v, cur.c + o.c));
					dis[o.v] = cur.c + o.c;
				}
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int v, c;

	public Edge(int v, int c) {
		this.v = v;
		this.c = c;
	}

	@Override
	public int compareTo(Edge o) {
		return this.c - o.c;
	}
}