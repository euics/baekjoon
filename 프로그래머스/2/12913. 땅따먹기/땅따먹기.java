class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        int[][] dp = new int[n][m];
        dp[n - 1] = land[n - 1].clone();

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                for(int l = 0; l < m; l++){
                    if(j == l) continue;

                    dp[i][j] = Integer.max(dp[i][j], land[i][j] + dp[i + 1][l]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int num : dp[0]) max = Integer.max(max, num);

        return max;
    }
}