import java.util.*;
import java.io.*;

public class Main {
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
	static int[] unf;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		unf = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			unf[i] = i;
		}

		int E = Integer.parseInt(st.nextToken());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			pq.add(new int[] {A, B, C});
		}

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (find(cur[0]) != find(cur[1])) {
				union(cur[0], cur[1]);
				sum += cur[2];
			}
		}

		System.out.println(sum);
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

		if (fa != fb) {
			unf[fa] = fb;
		}
	}
}