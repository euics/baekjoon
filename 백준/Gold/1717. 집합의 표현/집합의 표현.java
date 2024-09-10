import java.io.*;
import java.util.*;

class Main {
	static int[] unf;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		init(n);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int condition = Integer.parseInt(st.nextToken());
			switch (condition) {
				case 0:
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;
				case 1:
					if (find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken())))
						sb.append("YES").append("\n");
					else
						sb.append("NO").append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	public static void init(int n) {
		unf = new int[n + 1];
		for (int i = 0; i <= n; i++)
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