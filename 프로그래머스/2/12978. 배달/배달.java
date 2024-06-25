import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;

	public int solution(int N, int[][] road, int K) {
		int answer = 0;

		init(N, road);
		dijkstra(1);

		for (int i = 1; i <= N; i++) {
			if (dis[i] <= K)
				answer++;
		}

		return answer;
	}

	public void init(int N, int[][] roads) {
		dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<Edge>());
		for (int i = 0; i < roads.length; i++) {
			graph.get(roads[i][0]).add(new Edge(roads[i][1], roads[i][2]));
			graph.get(roads[i][1]).add(new Edge(roads[i][0], roads[i][2]));
		}
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