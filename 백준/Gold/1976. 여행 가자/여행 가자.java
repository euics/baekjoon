import java.io.*;
import java.util.*;

class Main {
	static int[] unf;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		init(n);

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int city = Integer.parseInt(st.nextToken());
				if(city == 1) union(i, j);
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		if(travel(st))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static void init(int n) {
		unf = new int[n];
		for(int i = 0; i < n; i++) unf[i] = i;
	}

	public static int find(int v) {
		if(v == unf[v]) return unf[v];
		else return unf[v] = find(unf[v]);
	}

	public static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);

		if(fa != fb) unf[fa] = fb;
	}

	public static boolean travel(StringTokenizer st) {
		int start = Integer.parseInt(st.nextToken()) - 1;
		int parent = find(start);

		while (st.hasMoreTokens()) {
			int cur = Integer.parseInt(st.nextToken()) - 1;
			if(parent != find(cur)) return false;
		}

		return true;
	}
}