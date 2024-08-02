import java.io.*;
import java.util.*;

public class Main {
	public static int[] unf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		init(V);

		List<Edge> graph = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph.add(new Edge(A, B, C));
		}
		Collections.sort(graph);

		int answer = 0;
		for (Edge o : graph) {
			int fv1 = find(o.src);
			int fv2 = find(o.des);

			if (fv1 != fv2) {
				answer += o.c;
				union(o.src, o.des);
			}
		}

		System.out.println(answer);
	}

	public static void init(int V) {
		unf = new int[V + 1];
		for (int i = 1; i <= V; i++)
			unf[i] = i;
	}

	public static int find(int v) {
		if (v == unf[v])
			return unf[v];
		else
			return unf[v] = find(unf[v]);
	}

	public static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);

		if (fa != fb)
			unf[fa] = fb;
	}
}

class Edge implements Comparable<Edge> {
	int src, des, c;

	public Edge(int src, int des, int c) {
		this.src = src;
		this.des = des;
		this.c = c;
	}

	@Override
	public int compareTo(Edge o) {
		return this.c - o.c;
	}
}