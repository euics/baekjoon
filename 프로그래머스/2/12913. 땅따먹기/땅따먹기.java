class Solution {
	int solution(int[][] land) {
		int n = land.length;
		int m = land[0].length;

		int[][] dp = new int[n][m];
		dp[0] = land[0].clone();

		for (int row = 1; row < n; row++) {
			for (int col = 0; col < m; col++) {

				int max = Integer.MIN_VALUE;
				for (int tmp = 0; tmp < m; tmp++) {

					if (col == tmp)
						continue;

					max = Math.max(max, land[row][col] + dp[row - 1][tmp]);
				}

				dp[row][col] = max;
			}
		}

		int answer = Integer.MIN_VALUE;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				answer = Math.max(answer, dp[row][col]);
			}
		}

		return answer;
	}
}