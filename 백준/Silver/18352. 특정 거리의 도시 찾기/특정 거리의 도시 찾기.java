import java.io.*;
import java.util.*;

class Main {
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		init(N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		dijkstra(X);

		List<Integer> answer = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (dis[i] == K)
				answer.add(i);
		}

		Collections.sort(answer);
		for(int i = 0; i < answer.size(); i++)
			System.out.println(answer.get(i));

		if(answer.isEmpty())
			System.out.println(-1);
	}

	public static void init(int N) {
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<Edge>());

		dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
	}

	public static void addEdge(int a, int b) {
		graph.get(a).add(new Edge(b, 1));
	}

	public static void dijkstra(int v) {
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