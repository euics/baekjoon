class Solution {
    static int[][] costs;
    static int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        initCosts(n, m, puddles);
        
        costs[1][1] = 1;
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= m; col++) {
                if((row == 1 && col == 1) || costs[row][col] == -1) continue;
                
                if(costs[row - 1][col] != -1) costs[row][col] = (costs[row - 1][col] + costs[row][col]) % MOD;
                if(costs[row][col - 1] != -1) costs[row][col] = (costs[row][col - 1] + costs[row][col]) % MOD;
            }
        }
        
        return costs[n][m];
    }
    
    public void initCosts(int n, int m, int[][] puddles) {
        costs = new int[n + 1][m + 1];
        for(int[] puddle : puddles) costs[puddle[1]][puddle[0]] = -1;
    }
}