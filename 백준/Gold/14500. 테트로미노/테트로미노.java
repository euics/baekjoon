import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] bool;
	static int max = Integer.MIN_VALUE;
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		init();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bool[i][j] = true;
				DFS(1, j, i, arr[i][j]);
				bool[i][j] = false;
			}
		}

		System.out.println(max);
	}

	public static void DFS(int L, int x, int y, int sum) {
		if (L == 4) {
			max = Math.max(max, sum);

			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dix[d];
			int ny = y + diy[d];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (!bool[ny][nx]) {
					if (L == 2) {
						bool[ny][nx] = true;
						DFS(L + 1, x, y, sum + arr[ny][nx]);
						bool[ny][nx] = false;
					}

					bool[ny][nx] = true;
					DFS(L + 1, nx, ny, sum + arr[ny][nx]);
					bool[ny][nx] = false;
				}
			}
		}
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
			}
		}

		bool = new boolean[N][M];
	}
}