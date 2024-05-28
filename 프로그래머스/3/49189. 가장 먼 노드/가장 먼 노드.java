import java.util.*;

class Solution {
	static ArrayList<ArrayList<Edge>> graph;
	static int[] costs;

	public int solution(int n, int[][] edge) {
		init(n, edge);
		dijkstra(1);
		int max = findMax(n);

		return countMax(n, max);
	}

	public void init(int n, int[][] edges) {
		costs = new int[n + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);

		graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) graph.add(new ArrayList<Edge>());

		for(int[] edge : edges) {
			graph.get(edge[0]).add(new Edge(edge[1], 1));
			graph.get(edge[1]).add(new Edge(edge[0], 1));
		}
	}

	public void dijkstra(int v) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(v, 0));
		costs[v] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if(costs[cur.v] < cur.c) continue;

			for(Edge o : graph.get(cur.v)) {
				if(costs[o.v] > cur.c + o.c) {
					costs[o.v] = cur.c + o.c;
					pq.add(new Edge(o.v, cur.c + o.c));
				}
			}
		}
	}
	
	public int findMax(int n) {
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++) max = Math.max(max, costs[i]);
		
		return max;
	}
	
	public int countMax(int n, int max) {
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(costs[i] == max) cnt++;
		}
		
		return cnt;
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