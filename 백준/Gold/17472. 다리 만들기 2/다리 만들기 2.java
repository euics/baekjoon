import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] bool;
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};
	static int landNum = 1;
	static List<Edge> edge;
	static int[] unf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		bool = new boolean[N][M];
		edge = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 0 && !bool[i][j]) {
					DFS(j, i);
					landNum++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] > 0)
					findBridge(j, i, arr[i][j]);
			}
		}
		Collections.sort(edge);

		init(--landNum);
		int answer = 0;
		for (Edge o : edge) {
			int fv1 = find(o.src);
			int fv2 = find(o.des);

			if (fv1 != fv2) {
				union(o.src, o.des);
				answer += o.c;
			}
		}

		boolean flag = true;
		int parent = find(1);
		for (int i = 2; i <= landNum; i++) {
			if (parent != find(i)) {
				flag = false;
				break;
			}
		}

		if (flag)
			System.out.println(answer);
		else
			System.out.println(-1);
	}

	public static void init(int V) {
		unf = new int[V + 1];
		for (int i = 1; i <= V; i++)
			unf[i] = i;
	}

	public static void DFS(int x, int y) {
		arr[y][x] = landNum;
		bool[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dix[d];
			int ny = y + diy[d];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N && arr[ny][nx] != 0) {
				if (!bool[ny][nx]) {
					bool[ny][nx] = true;
					arr[ny][nx] = landNum;
					DFS(nx, ny);
				}
			}
		}
	}

	public static void findBridge(int x, int y, int id) {
		for (int d = 0; d < 4; d++) {
			int nx = x, ny = y, length = 0;

			while (true) {
				nx += dix[d];
				ny += diy[d];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N || arr[ny][nx] == id)
					break;
				if (arr[ny][nx] > 0 && arr[ny][nx] != id) {
					if (length >= 2)
						edge.add(new Edge(id, arr[ny][nx], length));
					break;
				}

				length++;
			}
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