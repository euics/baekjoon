import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static List<int[]> cloud = new ArrayList<>();
	static int[] dix = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] diy = {0, -1, -1, -1, 0, 1, 1, 1};

	public static void main(String[] args) throws IOException {
		init();

	}

	public static void move(int d) {
		for (int i = 0; i < cloud.size(); i++) {
			int nx = cloud.get(i)[0] + dix[d];
			int ny = cloud.get(i)[1] + diy[d];

			if (nx == -1)
				nx = N - 1;
			if (nx == N)
				nx = 0;
			if (ny == -1)
				ny = N - 1;
			if (ny == N)
				ny = 0;

			cloud.get(i)[0] = nx;
			cloud.get(i)[1] = ny;
		}
	}

	public static void pourWater() {
		for (int i = 0; i < cloud.size(); i++) {
			int cnt = 0, dir = -1;
			int x = cloud.get(i)[0];
			int y = cloud.get(i)[1];

			for (int d = 0; d < 4; d++) {
				dir = dir + 2;

				int nx = x + dix[dir];
				int ny = y + diy[dir];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (arr[ny][nx] > 0) {
						cnt++;
					}
				}
			}

			arr[y][x] += cnt;
		}
	}

	public static int total() {
		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += arr[i][j];
			}
		}

		return sum;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cloud.add(new int[] {0, N - 2});
		cloud.add(new int[] {1, N - 2});
		cloud.add(new int[] {0, N - 1});
		cloud.add(new int[] {1, N - 1});

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());

			for (int j = 0; j < s; j++) {
				move(d);
			}

			boolean[][] wasCloud = new boolean[N][N];

			for (int j = 0; j < cloud.size(); j++) {
				int x = cloud.get(j)[0];
				int y = cloud.get(j)[1];
				arr[y][x]++;
				wasCloud[y][x] = true;
			}

			pourWater();

			List<int[]> newCloud = new ArrayList<>();
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (!wasCloud[y][x] && arr[y][x] >= 2) {
						newCloud.add(new int[] {x, y});
						arr[y][x] -= 2;
					}
				}
			}

			cloud = newCloud;
		}

		System.out.println(total());
	}
}