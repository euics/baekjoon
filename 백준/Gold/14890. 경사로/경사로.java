import java.util.*;
import java.io.*;

public class Main {
	static int N, L, answer = 0;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		init();

		for (int i = 0; i < N; i++) {
			if (line(arr[i])) {
				answer++;
			}
		}

		for (int j = 0; j < N; j++) {
			int[] line = new int[N];

			for (int i = 0; i < N; i++) {
				line[i] = arr[i][j];
			}

			if (line(line)) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static boolean line(int[] line) {
		boolean[] bool = new boolean[N];

		for (int i = 0; i < N - 1; i++) {
			int diff = line[i + 1] - line[i];

			if (diff == 0) {
				continue;
			}

			if (diff == 1) {
				for (int j = 0; j < L; j++) {
					if (i - j < 0 || bool[i - j] || line[i - j] != line[i]) {
						return false;
					}

					bool[i - j] = true;
				}
			} else if (diff == -1) {
				for (int j = 0; j < L; j++) {
					if (i + j + 1 >= N || bool[i + j + 1] || line[i + j + 1] != line[i + 1]) {
						return false;
					}

					bool[i + j + 1] = true;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}