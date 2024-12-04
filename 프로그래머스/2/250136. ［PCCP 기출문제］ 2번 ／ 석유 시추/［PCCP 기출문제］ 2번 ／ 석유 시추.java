import java.util.*;

class Solution {
	static int L = 0, idx = 1, answer = Integer.MIN_VALUE;
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};
	static Map<Integer, Integer> map = new HashMap<>();

	public int solution(int[][] land) {
		boolean[][] bool = new boolean[land.length][land[0].length];

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				if (land[i][j] == 1 && !bool[i][j]) {
					L = 0;
					DFS(land, j, i, bool);

					map.put(idx, L);
					idx++;
				}
			}
		}

		for (int x = 0; x < land[0].length; x++) {
			int sum = 0;
			Set<Integer> set = new HashSet<>();

			for (int y = 0; y < land.length; y++) {
				if (land[y][x] != 0 && !set.contains(land[y][x])) {
					sum += map.get(land[y][x]);
					set.add(land[y][x]);
				}
			}

			answer = Math.max(answer, sum);
		}

		return answer;
	}

	public void DFS(int[][] land, int x, int y, boolean[][] bool) {
		L++;
		land[y][x] = idx;
		bool[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dix[d];
			int ny = y + diy[d];

			if (nx >= 0 && ny >= 0 && nx < land[0].length && ny < land.length && land[ny][nx] == 1) {
				if (!bool[ny][nx]) {
					bool[ny][nx] = true;
					DFS(land, nx, ny, bool);
				}
			}
		}
	}
}