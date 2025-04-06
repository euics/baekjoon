import java.util.*;
import java.io.*;

public class Main {
	static int N, M;

	static int[][] arr;
	static boolean[][] bool;

	static int y, x, d;

	static int[] dix = {0, 1, 0, -1}; // 북 동 남 서
	static int[] diy = {-1, 0, 1, 0};

	static int answer = 0;

	public static void main(String[] args) throws IOException {
		init();

		boolean stop = false;
		while (!stop) {
			if (arr[y][x] == 0) {
				arr[y][x] = 2;
				answer++;
			}

			boolean canMove = false;
			for (int i = 0; i < 4; i++) {
				d = (d + 3) % 4;
				int nx = x + dix[d];
				int ny = y + diy[d];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N && arr[ny][nx] == 0) {
					x = nx;
					y = ny;
					canMove = true;
					break;
				}
			}

			if (!canMove) {
				int back = (d + 2) % 4;
				int nx = x + dix[back];
				int ny = y + diy[back];

				if (arr[ny][nx] == 1) {
					stop = true;
				} else {
					x = nx;
					y = ny;
				}
			}
		}

		System.out.println(answer);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		bool = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 1) {

				}
			}
		}
	}
}