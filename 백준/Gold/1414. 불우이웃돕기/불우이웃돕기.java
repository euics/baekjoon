import java.io.*;
import java.util.*;

class Main {
	static int[] unf;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		unf = new int[N];
		for (int i = 0; i < N; i++)
			unf[i] = i;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		int total = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			for (int j = 0; j < N; j++) {
				int num = 0;

				if (Character.isLowerCase(input.charAt(j)))
					num = (int)input.charAt(j) - (int)'a' + 1;
				if (Character.isUpperCase(input.charAt(j)))
					num = (int)input.charAt(j) - (int)'A' + 27;
				total += num;

				if (i == j)
					continue;

				if (input.charAt(j) != '0')
					pq.add(new int[] {i, j, num});
			}
		}

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (find(cur[0]) != find(cur[1])) {
				union(cur[0], cur[1]);
				total -= cur[2];
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
			System.out.println(total);
		else
			System.out.println(-1);
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

/*
 (int)'z' - (int)'a' + 1
 (int)'Z' - (int)'A' + 27
*/