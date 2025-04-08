import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int x, y;
	static int K;
	static int[][] arr;
	static int[] order;
	static int[] dice = new int[] {0, 0, 0, 0, 0, 0};

	public static void main(String[] args) throws IOException {
		init();

		for (int i = 0; i < K; i++) {
			int dir = order[i];

			if (dir == 1) {
				int nx = x + 1;
				int ny = y;

				if (!isValid(nx, ny)) {
					continue;
				}
				right();

				x = nx;
				y = ny;
				copy(x, y);
			} else if (dir == 2) {
				int nx = x - 1;
				int ny = y;

				if (!isValid(nx, ny)) {
					continue;
				}
				left();

				x = nx;
				y = ny;
				copy(x, y);
			} else if (dir == 3) {
				int nx = x;
				int ny = y - 1;

				if (!isValid(nx, ny)) {
					continue;
				}
				up();

				x = nx;
				y = ny;
				copy(x, y);
			} else {
				int nx = x;
				int ny = y + 1;

				if (!isValid(nx, ny)) {
					continue;
				}
				down();

				x = nx;
				y = ny;
				copy(x, y);
			}

			System.out.println(dice[1]);
		}
	}

	public static void right() {
		int tmp = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = dice[3];
		dice[3] = tmp;
	}

	public static void left() {
		int tmp = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[3];
		dice[3] = tmp;
	}

	public static void up() {
		int tmp = dice[0];
		dice[0] = dice[1];
		dice[1] = dice[2];
		dice[2] = dice[3];
		dice[3] = tmp;
	}

	public static void down() {
		int tmp = dice[3];
		dice[3] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[0];
		dice[0] = tmp;
	}

	public static void copy(int x, int y) {
		if (arr[y][x] != 0) {
			dice[3] = arr[y][x];
			arr[y][x] = 0;
		} else {
			arr[y][x] = dice[3];
		}
	}

	public static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		order = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
	}
}