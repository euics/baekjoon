import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	static char[][] arr;
	static boolean[][] bool;
	static int sum = 0;

	public int[] solution(String[] maps) {
		int n = maps.length;
		int m = maps[0].length();

		init(maps);

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!bool[i][j] && arr[i][j] != 'X') {
					sum = Character.getNumericValue(arr[i][j]);
					DFS(j, i, n, m);
					answer.add(sum);
				}
			}
		}

		Collections.sort(answer);
		return answer.size() == 0 ? new int[] {-1} : answer.stream().mapToInt(i -> i).toArray();
	}

	public void init(String[] maps) {
		int n = maps.length;
		int m = maps[0].length();

		arr = new char[n][m];
		bool = new boolean[n][m];

		for (int i = 0; i < maps.length; i++) {
			char[] ch = maps[i].toCharArray();
			for (int j = 0; j < ch.length; j++)
				arr[i][j] = ch[j];
		}
	}

	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};

	public void DFS(int x, int y, int n, int m) {
		bool[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dix[d];
			int ny = y + diy[d];

			if (nx >= 0 && ny >= 0 && nx < m && ny < n && Character.isDigit(arr[ny][nx])) {
				if (!bool[ny][nx]) {
					bool[ny][nx] = true;
					sum += Character.getNumericValue(arr[ny][nx]);
					DFS(nx, ny, n, m);
				}
			}
		}
	}
}