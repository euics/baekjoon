import java.io.*;
import java.util.*;

class Main {
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i <= V; i++)
			graph.add(new ArrayList<Edge>());
		dis = new int[V + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph.get(u).add(new Edge(v, w));
		}

		dijkstra(start);

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(dis[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(dis[i]).append("\n");
		}

		System.out.println(sb.toString());
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start , 0));
		dis[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(dis[cur.v] < cur.c) continue;

			for(Edge o : graph.get(cur.v)) {
				if(dis[o.v] > cur.c + o.c) {
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