import java.util.Arrays;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] map = init(m, n, puddles);

        map[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(map[i][j] == -1 || (i == 1 && j == 1)) continue;

                if(map[i][j - 1] != -1) map[i][j] = (map[i][j] + map[i][j - 1]) % MOD;
                if(map[i - 1][j] != -1) map[i][j] = (map[i][j] + map[i - 1][j]) % MOD;
            }
        }
        
        return map[n][m];
    }

    private int[][] init(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        for (int[] puddle : puddles) map[puddle[1]][puddle[0]] = -1;

        return map;
    }
}