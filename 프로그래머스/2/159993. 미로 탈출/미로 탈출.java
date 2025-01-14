import java.util.*;

class Solution {
	static int n, m;
	static char[][] arr;
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};
	int[] S = new int[2];
	int[] L = new int[2];
	int[] E = new int[2];

	public int solution(String[] maps) {
		n = maps.length;
		m = maps[0].length();
		arr = new char[n][m];

		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				arr[i][j] = maps[i].charAt(j);

				if (arr[i][j] == 'S') {
					S[0] = j;
					S[1] = i;
					arr[i][j] = 'O';
				}

				if (arr[i][j] == 'L') {
					L[0] = j;
					L[1] = i;
					arr[i][j] = 'O';
				}

				if (arr[i][j] == 'E') {
					E[0] = j;
					E[1] = i;
					arr[i][j] = 'O';
				}
			}
		}

		int toL = BFS(S[0], S[1], L[0], L[1]);
		int toE = BFS(L[0], L[1], E[0], E[1]);

		if (toL == -1 || toE == -1) {
			return -1;
		} else {
			return toL + toE;
		}
	}

	public int BFS(int srcX, int srcY, int desX, int desY) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {srcX, srcY});
		boolean[][] bool = new boolean[n][m];
		bool[srcY][srcX] = true;

		int L = 0;
		while (!q.isEmpty()) {
			int length = q.size();

			for (int i = 0; i < length; i++) {
				int[] cur = q.poll();

				if (cur[0] == desX && cur[1] == desY) {
					return L;
				}

				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dix[d];
					int ny = cur[1] + diy[d];

					if (nx >= 0 && ny >= 0 && nx < m && ny < n && arr[ny][nx] == 'O') {
						if (!bool[ny][nx]) {
							bool[ny][nx] = true;
							q.add(new int[] {nx, ny});
						}
					}
				}
			}

			L++;
		}

		return -1;
	}
}