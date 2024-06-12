import java.util.Stack;

class Solution {
	static char[][] arr;
	static boolean[][] bool;

	public int solution(int m, int n, String[] board) {
		int answer = 0;

		arr = new char[m][n];
		for (int i = 0; i < m; i++)
			arr[i] = board[i].toCharArray();

		while (true) {
			bool = new boolean[m][n];

			for (int row = 0; row < m - 1; row++) {
				for (int col = 0; col < n - 1; col++) {
					if (arr[row][col] == ' ')
						continue;

					findSameBlocks(row, col, arr[row][col]);
				}
			}

			int cnt = removeBlocks(m, n);
			answer += cnt;
			if (cnt == 0)
				break;

			dropBlocks(m, n);
		}

		return answer;
	}

	public void findSameBlocks(int row, int col, char block) {
		for (int i = row; i < row + 2; i++) {
			for (int j = col; j < col + 2; j++) {
				if (arr[i][j] != block)
					return;
			}
		}

		for (int i = row; i < row + 2; i++) {
			for (int j = col; j < col + 2; j++) {
				bool[i][j] = true;
			}
		}
	}

	public int removeBlocks(int m, int n) {
		int cnt = 0;

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (bool[row][col]) {
					arr[row][col] = ' ';
					cnt++;
				}
			}
		}

		return cnt;
	}

	public void dropBlocks(int m, int n) {
		for (int col = 0; col < n; col++) {
			Stack<Character> stack = new Stack<>();

			for (int row = 0; row < m; row++) {
				if (arr[row][col] != ' ') {
					stack.push(arr[row][col]);
					arr[row][col] = ' ';
				}
			}

			int index = m - 1;
			while (!stack.isEmpty())
				arr[index--][col] = stack.pop();
		}
	}
}