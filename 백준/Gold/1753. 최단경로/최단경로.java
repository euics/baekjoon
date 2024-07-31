import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<ArrayList<Edge>> graph;
	public static int[] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		init(V);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Edge(v, w));
		}

		dijkstra(start);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(dis[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dis[i]).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void init(int V) {
		dis = new int[V + 1];
		for (int i = 0; i <= V; i++)
			Arrays.fill(dis, Integer.MAX_VALUE);

		graph = new ArrayList<>();
		for (int i = 0; i <= V; i++)
			graph.add(new ArrayList<Edge>());
	}

	public static void dijkstra(int v) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.c - b.c);
		pq.add(new Edge(v, 0));
		dis[v] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (dis[cur.v] < cur.c)
				continue;

			for (Edge o : graph.get(cur.v)) {
				if (dis[o.v] > o.c + cur.c) {
					dis[o.v] = o.c + cur.c;
					pq.add(new Edge(o.v, o.c + cur.c));
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