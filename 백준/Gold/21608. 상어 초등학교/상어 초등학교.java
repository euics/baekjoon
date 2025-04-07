import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] arr, favorite;
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		init();

	}

	public static List<int[]> findFavoriteArea(int student) {
		int max = Integer.MIN_VALUE;

		for (int dy = 0; dy < N; dy++) {
			for (int dx = 0; dx < N; dx++) {
				int cnt = 0;

				if (arr[dy][dx] != 0)
					continue;

				for (int d = 0; d < 4; d++) {
					int nx = dx + dix[d];
					int ny = dy + diy[d];

					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						for (int l = 0; l < 4; l++) {
							if (favorite[student][l] == arr[ny][nx]) {
								cnt++;
							}
						}
					}
				}

				if (max <= cnt) {
					max = cnt;
				}
			}
		}

		List<int[]> list = new ArrayList<>();
		for (int dy = 0; dy < N; dy++) {
			for (int dx = 0; dx < N; dx++) {
				int cnt = 0;

				if (arr[dy][dx] != 0)
					continue;

				for (int d = 0; d < 4; d++) {
					int nx = dx + dix[d];
					int ny = dy + diy[d];

					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						for (int l = 0; l < 4; l++) {
							if (favorite[student][l] == arr[ny][nx]) {
								cnt++;
							}
						}
					}
				}

				if (max == cnt) {
					list.add(new int[] {dx, dy});
				}
			}
		}

		return list;
	}

	public static List<int[]> findZeroArea(List<int[]> favoriteArea) {
		int max = Integer.MIN_VALUE;

		for (int[] coordinate : favoriteArea) {
			int cnt = 0;

			for (int d = 0; d < 4; d++) {
				int nx = coordinate[0] + dix[d];
				int ny = coordinate[1] + diy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (arr[ny][nx] == 0) {
						cnt++;
					}
				}
			}

			if (max <= cnt) {
				max = cnt;
			}
		}

		List<int[]> zeroArea = new ArrayList<>();
		for (int[] coordinate : favoriteArea) {
			int cnt = 0;

			for (int d = 0; d < 4; d++) {
				int nx = coordinate[0] + dix[d];
				int ny = coordinate[1] + diy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (arr[ny][nx] == 0) {
						cnt++;
					}
				}
			}

			if (max == cnt) {
				zeroArea.add(new int[] {coordinate[0], coordinate[1]});
			}
		}

		return zeroArea;
	}

	public static int calculate() {
		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int student = arr[i][j], cnt = 0;

				for (int d = 0; d < 4; d++) {
					int nx = j + dix[d];
					int ny = i + diy[d];

					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						for (int l = 0; l < 4; l++) {
							if (favorite[student][l] == arr[ny][nx]) {
								cnt++;
							}
						}
					}
				}

				if (cnt == 0) {
					sum += 0;
				} else if (cnt == 1) {
					sum += 1;
				} else if (cnt == 2) {
					sum += 10;
				} else if (cnt == 3) {
					sum += 100;
				} else {
					sum += 1000;
				}
			}
		}

		return sum;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		favorite = new int[N * N + 1][4];
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 4; j++) {
				favorite[student][j] = Integer.parseInt(st.nextToken());
			}

			List<int[]> favoriteArea = findFavoriteArea(student);
			if (favoriteArea.size() == 1) {
				arr[favoriteArea.get(0)[1]][favoriteArea.get(0)[0]] = student;
			} else {
				List<int[]> zeroArea = findZeroArea(favoriteArea);
				Collections.sort(zeroArea, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

				arr[zeroArea.get(0)[1]][zeroArea.get(0)[0]] = student;
			}
		}

		System.out.println(calculate());
	}
}