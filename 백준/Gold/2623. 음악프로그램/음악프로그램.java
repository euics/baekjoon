import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] inDegree;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		inDegree = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int[] tmp = new int[size];

			for (int j = 0; j < size; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < size - 1; j++) {
				graph.get(tmp[j]).add(tmp[j + 1]);
				inDegree[tmp[j + 1]]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		int sortCnt = 0;
		while (!q.isEmpty()) {
			int prev = q.poll();
			sortCnt++;
			sb.append(prev).append("\n");

			for (int next : graph.get(prev)) {
				inDegree[next]--;
				if (inDegree[next] == 0) {
					q.add(next);
				}
			}
		}

		if (sortCnt == N) {
			System.out.println(sb.toString());
		} else {
			System.out.println(0);
		}
	}
}