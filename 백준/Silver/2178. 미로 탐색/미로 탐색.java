import java.io.*;
import java.util.*;

class Main {
	static int[][] arr;
	static boolean[][] bool;
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		bool = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++)
				arr[i][j] = Character.getNumericValue(input[j]);
		}

		System.out.println(BFS(N, M));
	}

	public static int BFS(int N, int M) {
		bool[0][0] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});

		int L = 1;
		while (!q.isEmpty()) {
			int length = q.size();

			for (int i = 0; i < length; i++) {
				int[] cur = q.poll();

				if (cur[0] == M - 1 && cur[1] == N - 1)
					return L;

				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dix[d];
					int ny = cur[1] + diy[d];

					if (nx >= 0 && ny >= 0 && nx < M && ny < N && arr[ny][nx] == 1) {
						if (!bool[ny][nx]) {
							bool[ny][nx] = true;
							q.add(new int[] {nx, ny});
						}
					}
				}
			}

			L++;
		}

		return 1;
	}
}