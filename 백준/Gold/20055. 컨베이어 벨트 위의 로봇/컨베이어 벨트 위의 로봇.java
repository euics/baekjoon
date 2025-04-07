import java.util.*;
import java.io.*;

public class Main {
	static int answer = 0;
	static int N, K;
	static int[][] arr;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {
		init();

		while (!stop()) {
			answer++;

			rotate();
			fall();

			move();
			fall();

			put();
		}

		System.out.println(answer);
	}

	public static void rotate() {
		int fir = arr[0][0];
		arr[0][0] = arr[1][0];
		for (int i = 0; i < N - 1; i++) {
			arr[1][i] = arr[1][i + 1];
		}

		arr[1][N - 1] = arr[0][N - 1];
		for (int i = N - 1; i >= 2; i--) {
			arr[0][i] = arr[0][i - 1];
		}

		arr[0][1] = fir;

		for (int i = N - 1; i >= 1; i--) {
			robot[i] = robot[i - 1];
		}

		robot[0] = false;
	}

	public static void move() {
		for (int i = N - 2; i >= 0; i--) {
			if (arr[0][i + 1] != 0 && !robot[i + 1] && robot[i]) {
				arr[0][i + 1]--;
				robot[i + 1] = true;
				robot[i] = false;
			}
		}
	}

	public static void put() {
		if (!robot[0] && arr[0][0] != 0) {
			robot[0] = true;
			arr[0][0]--;
		}
	}

	public static void fall() {
		robot[N - 1] = false;
	}

	public static boolean stop() {
		int cnt = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					cnt++;
				}
			}
		}

		return cnt >= K;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[2][N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} else {
				for (int j = N - 1; j >= 0; j--) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		robot = new boolean[N];

		// for (int i = 0; i < 2; i++) {
		// 	for (int j = 0; j < N; j++) {
		// 		System.out.printf("%d ", belt[i][j]);
		// 	}
		// 	System.out.println();
		// }
	}
}