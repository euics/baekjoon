import java.io.*;
import java.util.*;

public class Main {
	static int[] dis;
	static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Edge>());
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken()))
				.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int src = Integer.parseInt(st.nextToken());
		int des = Integer.parseInt(st.nextToken());
		dijkstra(src);
		System.out.println(dis[des]);
	}

	public static void dijkstra(int src) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(src, 0));
		dis[src] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (cur.c > dis[cur.v]) {
				continue;
			}

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