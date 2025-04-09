import java.util.*;
import java.io.*;

public class Main {
	static int R, C, T;
	static int[][] arr;
	static int[] air = new int[2];
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		init();

		// for (int i = 0; i < R; i++) {
		// 	for (int j = 0; j < C; j++) {
		// 		System.out.printf("%d ", arr[i][j]);
		// 	}
		// 	System.out.println();
		// }
		//
		// System.out.println();
		// System.out.println();

		while (T > 0) {
			Queue<int[]> dust = dust();

			int[][] spread = spread(dust);
			afterSpread(spread);
			up();
			down();

			T--;
		}

		System.out.println(sum() + 2);
	}

	public static void up() {
		int tmp = arr[0][0];

		for (int j = 0; j < C - 1; j++) {
			arr[0][j] = arr[0][j + 1];
		}

		for (int i = 0; i < air[0]; i++) {
			arr[i][C - 1] = arr[i + 1][C - 1];
		}

		for (int j = C - 1; j > 0; j--) {
			arr[air[0]][j] = arr[air[0]][j - 1];
		}

		for (int i = air[0]; i > 1; i--) {
			arr[i][0] = arr[i - 1][0];
		}

		arr[1][0] = tmp;
		arr[air[0]][1] = 0;
		arr[air[0]][0] = -1;
	}

	public static void down() {
		int tmp = arr[air[1]][C - 1];

		for (int j = C - 1; j > 0; j--) {
			arr[air[1]][j] = arr[air[1]][j - 1];
		}

		for (int i = air[1]; i < R - 1; i++) {
			arr[i][0] = arr[i + 1][0];
		}

		for (int j = 0; j < C - 1; j++) {
			arr[R - 1][j] = arr[R - 1][j + 1];
		}

		for (int i = R - 1; i > air[1] + 1; i--) {
			arr[i][C - 1] = arr[i - 1][C - 1];
		}

		arr[air[1] + 1][C - 1] = tmp;
		arr[air[1]][1] = 0;
		arr[air[1]][0] = -1;
	}

	public static int[][] spread(Queue<int[]> dust) {
		int[][] tmp = new int[R][C];

		while (!dust.isEmpty()) {
			int[] cur = dust.poll();
			int cnt = 0;

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dix[d];
				int ny = cur[1] + diy[d];

				if (isValid(nx, ny)) {
					cnt++;
					tmp[ny][nx] += arr[cur[1]][cur[0]] / 5;
				}
			}

			if (cnt > 0) {
				int spread = cnt * (arr[cur[1]][cur[0]] / 5);
				tmp[cur[1]][cur[0]] -= spread;
			}
		}

		return tmp;
	}

	public static Queue<int[]> dust() {
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0) {
					q.add(new int[] {j, i});
				}
			}
		}

		return q;
	}

	public static void afterSpread(int[][] spread) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arr[i][j] += spread[i][j];
			}
		}
	}

	public static void air() {
		for (int i = 0, idx = 0; i < R; i++) {
			if (arr[i][0] == -1) {
				air[idx] = i;
				idx++;
			}
		}
	}

	public static int sum() {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += arr[i][j];
			}
		}

		return sum;
	}

	public static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < C && y < R && arr[y][x] != -1;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		air();
	}
}