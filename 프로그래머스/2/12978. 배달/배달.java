import java.util.*;

class Solution {
	static int answer = 0;
	static int[] dis;
	static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

	public int solution(int N, int[][] road, int K) {
		dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		for (int i = 0; i <= N; i++) {
			graph.add(i, new ArrayList<Edge>());
		}

		for (int i = 0; i < road.length; i++) {
			graph.get(road[i][0]).add(new Edge(road[i][1], road[i][2]));
			graph.get(road[i][1]).add(new Edge(road[i][0], road[i][2]));
		}

		dijkstra(1);

		for (int i = 1; i <= N; i++) {
			if (dis[i] != Integer.MAX_VALUE && dis[i] <= K) {
				answer++;
			}
		}

		return answer;
	}

	public void dijkstra(int v) {
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(v, 0));
		dis[v] = 0;

		while (!q.isEmpty()) {
			Edge cur = q.poll();

			if (dis[cur.v] < cur.c) {
				continue;
			}

			for (Edge o : graph.get(cur.v)) {
				if (dis[o.v] > cur.c + o.c) {
					dis[o.v] = cur.c + o.c;
					q.add(new Edge(o.v, cur.c + o.c));
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