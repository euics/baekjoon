import java.util.*;
import java.io.*;

public class Main {
	static int N, K, L;
	static int[][] arr;
	static int[] dix = {1, 0, -1, 0};
	static int[] diy = {0, 1, 0, -1};
	static int[][] change;

	public static void main(String[] args) throws IOException {
		init();

		System.out.println(BFS());
	}

	public static int BFS() {
		Deque<int[]> dq = new LinkedList<>();
		dq.add(new int[] {0, 0});

		int time = 0, x = 0, y = 0, d = 0;
		while (true) {
			time++;

			int nx = x + dix[d];
			int ny = y + diy[d];

			if (!isValid(dq, nx, ny)) {
				return time;
			}

			if (arr[ny][nx] == 0) {
				dq.pollFirst();
				dq.addLast(new int[] {nx, ny});
			} else {
				arr[ny][nx] = 0;
				dq.addLast(new int[] {nx, ny});
			}

			for (int i = 0; i < change.length; i++) {
				if (change[i][0] == time) {
					d = (d + change[i][1]) % 4;
				}
			}

			x = nx;
			y = ny;
		}
	}

	public static boolean isValid(Deque<int[]> dq, int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}

		int length = dq.size();
		for (int i = 0; i < length; i++) {
			int[] cur = dq.pollFirst();
			if (cur[0] == x && cur[1] == y) {
				return false;
			}

			dq.addLast(cur);
		}

		return true;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}

		L = Integer.parseInt(br.readLine());
		change = new int[L][2];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			change[i][0] = time;

			char dir = st.nextToken().charAt(0);

			if (dir == 'L') {
				change[i][1] = 3;
			} else if (dir == 'D') {
				change[i][1] = 1;
			}
		}
		Arrays.sort(change, (a, b) -> a[0] - b[0]);
	}
}