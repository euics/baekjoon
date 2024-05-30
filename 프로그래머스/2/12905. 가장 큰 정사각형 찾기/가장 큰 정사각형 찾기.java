class Solution {
	public int solution(int[][] board) {
		int max = 0;
		int[][] dp = new int[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = board[i][j];
				else if (board[i][j] == 1)
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
				else
					dp[i][j] = 0;

				max = Math.max(max, dp[i][j]);
			}
		}

		return max * max;
	}
}