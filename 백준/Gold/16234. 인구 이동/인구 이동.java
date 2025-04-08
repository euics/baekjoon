import java.util.*;
import java.io.*;

public class Main {
	static int answer = 0;
	static int N, L, R;
	static int[][] arr;
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		init();

		while (true) {
			boolean[][] bool = new boolean[N][N];
			boolean find = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!bool[i][j]) {
						if (union(j, i, bool)) {
							find = true;
						}
					}
				}
			}

			if (!find) {
				break;
			}

			answer++;
		}

		System.out.println(answer);
	}

	public static boolean union(int x, int y, boolean[][] bool) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		bool[y][x] = true;

		int sum = 0;
		Queue<int[]> union = new LinkedList<>();
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			union.add(new int[] {cur[0], cur[1]});
			sum += arr[cur[1]][cur[0]];

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dix[d];
				int ny = cur[1] + diy[d];

				if (isValid(nx, ny)) {
					if (!bool[ny][nx]) {
						int diff = Math.abs(arr[cur[1]][cur[0]] - arr[ny][nx]);
						if (diff >= L && diff <= R) {
							bool[ny][nx] = true;
							q.add(new int[] {nx, ny});
						}
					}
				}
			}
		}

		if (union.size() >= 2) {
			int length = union.size();

			while (!union.isEmpty()) {
				int[] cur = union.poll();
				arr[cur[1]][cur[0]] = sum / length;
			}

			return true;
		}

		return false;
	}

	public static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}