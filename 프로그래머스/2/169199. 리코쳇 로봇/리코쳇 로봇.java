import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static char[][] arr;
	static int[] start = new int[2];
	static int[] end = new int[2];
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};

	public int solution(String[] board) {
		init(board);
		return BFS();
	}

	public void init(String[] board) {
		int n = board.length;
		int m = board[0].length();
		arr = new char[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = board[i].charAt(j);

				if (arr[i][j] == 'R') {
					start[0] = j;
					start[1] = i;
				}

				if (arr[i][j] == 'G') {
					end[0] = j;
					end[1] = i;
				}
			}
		}
	}

	public int BFS() {
		int n = arr.length;
		int m = arr[0].length;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start[0], start[1]});
		boolean[][] bool = new boolean[n][m];
		bool[start[1]][start[0]] = true;

		int L = 0;
		while (!q.isEmpty()) {
			int length = q.size();

			for (int i = 0; i < length; i++) {
				int[] cur = q.poll();

				if (cur[0] == end[0] && cur[1] == end[1])
					return L;

				for (int d = 0; d < 4; d++) {
					int curX = cur[0];
					int curY = cur[1];

					while (true) {
						int nx = curX + dix[d];
						int ny = curY + diy[d];

						if (nx < 0 || ny < 0 || nx >= m || ny >= n || arr[ny][nx] == 'D')
							break;

						curX = nx;
						curY = ny;
					}

					if (!bool[curY][curX]) {
						bool[curY][curX] = true;
						q.add(new int[] {curX, curY});
					}
				}
			}
			
			L++;
		}
		
		return -1;
	}
}