import java.io.*;
import java.util.*;

class Main {
	static int A, B, C;
	static Set<Integer> set = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		BFS();
		
		StringBuilder sb = new StringBuilder();
		for (int x : set)
			sb.append(x).append(" ");
		System.out.println(sb.toString());
	}

	public static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, C});
		boolean[][][] bool = new boolean[201][201][201];

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int a = cur[0], b = cur[1], c = cur[2];
			if (bool[a][b][c])
				continue;
			bool[a][b][c] = true;

			if (a == 0)
				set.add(c);

			// 물 옮기기
			// A -> B
			if (a + b > B)
				q.add(new int[] {(a + b) - B, B, c});
			else
				q.add(new int[] {0, a + b, c});

			// A -> C
			if (a + c > C)
				q.add(new int[] {(a + c) - C, b, C});
			else
				q.add(new int[] {0, b, a + c});

			// B -> A
			if (b + a > A)
				q.add(new int[] {A, (a + b) - A, c});
			else
				q.add(new int[] {a + b, 0, c});

			// B -> C
			if (b + c > C)
				q.add(new int[] {a, (b + c) - C, C});
			else
				q.add(new int[] {a, 0, b + c});

			// C -> A
			if (c + a > A)
				q.add(new int[] {A, b, (a + c) - A});
			else
				q.add(new int[] {a + c, b, 0});

			// C -> B
			if (c + b > B)
				q.add(new int[] {a, B, (b + c) - B});
			else
				q.add(new int[] {a, b + c, 0});
		}
	}
}
