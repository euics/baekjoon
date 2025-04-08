import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static List<int[]> coordinate = new ArrayList<>();
	static int[] combination = new int[3];
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		init();

		DFS(0, 0);

		System.out.println(max);
	}

	public static void DFS(int L, int s) {
		if (L == 3) {
			max = Math.max(max, BFS());

			return;
		}

		for (int i = s; i < coordinate.size(); i++) {
			combination[L] = i;
			DFS(L + 1, i + 1);
		}
	}

	public static int BFS() {
		int[][] clone = new int[N][M];
		for (int i = 0; i < N; i++) {
			clone[i] = arr[i].clone();
		}

		for (int idx : combination) {
			clone[coordinate.get(idx)[1]][coordinate.get(idx)[0]] = 1;
		}

		Queue<int[]> q = virus();
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dix[d];
				int ny = cur[1] + diy[d];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N && clone[ny][nx] == 0) {
					clone[ny][nx] = 2;
					q.add(new int[] {nx, ny});
				}
			}
		}

		return count(clone);
	}

	public static Queue<int[]> virus() {
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 2) {
					q.add(new int[] {j, i});
				}
			}
		}

		return q;
	}

	public static int count(int[][] clone) {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (clone[i][j] == 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 0) {
					coordinate.add(new int[] {j, i});
				}
			}
		}
	}
}