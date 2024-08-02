import java.io.*;
import java.util.*;

public class Main {
	static int[] unf;

	// 96
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		init(N);

		int sum = 0;
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				int num = 0;
				if (input.charAt(j) >= 'a' && input.charAt(j) <= 'z')
					num = input.charAt(j) - 'a' + 1;
				if (input.charAt(j) >= 'A' && input.charAt(j) <= 'Z')
					num = input.charAt(j) - 'A' + 27;
				sum += num;

				if (i == j)
					continue;

				if (input.charAt(j) != '0')
					edges.add(new Edge(i, j, num));
			}
		}
		Collections.sort(edges);

		int donation = 0;
		for (Edge o : edges) {
			int fv1 = find(o.src);
			int fv2 = find(o.des);

			if (fv1 != fv2) {
				union(o.src, o.des);
				donation += o.c;
			}
		}

		boolean flag = true;
		int parent = find(0);
		for (int i = 1; i < N; i++) {
			if (parent != find(i)) {
				flag = false;
				break;
			}
		}

		if (flag)
			System.out.println(sum - donation);
		else
			System.out.println(-1);
	}

	public static void init(int N) {
		unf = new int[N];
		for (int i = 0; i < N; i++)
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