import java.io.*;
import java.util.*;

class Main {
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<Edge>());
		dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);

		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph.get(u).add(new Edge(v, w));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);

		System.out.println(dis[end]);
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