import java.io.*;
import java.util.*;

public class Main {
	static int[] unf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		init(N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++)
			set.add(find(i));

		System.out.println(set.size());
	}

	public static void init(int N) {
		unf = new int[N + 1];
		for (int i = 0; i <= N; i++)
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