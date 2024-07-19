import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		int[] answer = new int[sources.length];

		init(n, roads);
		dijkstra(destination);

		for (int i = 0; i < sources.length; i++)
			answer[i] = dis[sources[i]] == Integer.MAX_VALUE ? -1 : dis[sources[i]];

		return answer;
	}

	public void init(int n, int[][] roads) {
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			graph.add(new ArrayList<Edge>());

		for (int[] road : roads) {
			graph.get(road[0]).add(new Edge(road[1], 1));
			graph.get(road[1]).add(new Edge(road[0], 1));
		}

		dis = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
	}

	public void dijkstra(int v) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(v, 0));
		dis[v] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (dis[cur.v] < cur.c)
				continue;

			for (Edge o : graph.get(cur.v)) {
				if (dis[o.v] > cur.c + o.c) {
					dis[o.v] = cur.c + o.c;
					pq.add(new Edge(o.v, cur.c + o.c));
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