class Solution {
    int solution(int[][] land) {
        int n = land.length;

        int[][] dp = new int[n][4];
        dp[n - 1] = land[n - 1].clone();

        for(int row = n - 2; row >= 0; row--) {
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    if(i == j) continue;

                    dp[row][i] = Math.max(dp[row][i], land[row][i] + dp[row + 1][j]);
                }
            }

        }

        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < 4; i++)  answer = Math.max(answer, dp[0][i]);

        return answer;
    }
}