import java.io.*;
import java.util.*;

class Main {
	static int[] unf;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		init(N);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int city = Integer.parseInt(st.nextToken());
				if (city == 1)
					union(i + 1, j + 1);
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int prev = find(Integer.parseInt(st.nextToken()));
		boolean flag = true;
		for (int i = 0; i < M - 1; i++) {
			if (prev != find(Integer.parseInt(st.nextToken()))) {
				flag = false;
				break;
			}
		}

		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static void init(int N) {
		unf = new int[N + 1];
		for (int i = 0; i <= N; i++)
			unf[i] = i;
	}

	public static int find(int v) {
		if (v == unf[v])
			return v;
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
