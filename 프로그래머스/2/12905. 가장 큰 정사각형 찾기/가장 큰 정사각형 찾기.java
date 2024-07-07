import java.util.*;

class Solution {

	public int solution(int[][] board) {
		int n = board.length;
		int m = board[0].length;
		int max = Integer.MIN_VALUE;

		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = board[i][j];
				else if (board[i][j] == 1)
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
				else
					dp[i][j] = 0;

				max = Math.max(max, dp[i][j]);
			}
		}

		return max * max;
	}
}