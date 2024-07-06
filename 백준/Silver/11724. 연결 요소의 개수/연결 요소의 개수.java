import java.io.*;
import java.util.*;

class Main {
	static int[] unf;
	static int[] groupSize;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		init(N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			union(a, b);
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (unf[i] == i)
				answer++;
		}

		System.out.println(answer);
	}

	public static void init(int N) {
		unf = new int[N + 1];
		groupSize = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			unf[i] = i;
			groupSize[i] = 1;
		}
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
			groupSize[fb] += groupSize[fa];
		}
	}
}