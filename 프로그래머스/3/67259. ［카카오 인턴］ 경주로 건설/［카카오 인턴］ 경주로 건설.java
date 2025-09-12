import java.util.*;

class Solution {
    static int ans = Integer.MAX_VALUE;
    static int N;
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    public int solution(int[][] board) {
        N = board.length;
        int[][][] costs = new int[N][N][4];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) Arrays.fill(costs[i][j], Integer.MAX_VALUE);

        DFS(board, 0, 0, 0, -1, costs);

        return ans;
    }

    public void DFS(int[][] board, int x, int y, int cost, int prev, int[][][] costs) {
        if (x == N - 1 && y == N - 1) {
            ans = Math.min(ans, cost);

            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dix[d];
            int ny = y + diy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (board[ny][nx] == 1) continue;

            int add;
            if (prev == -1 || prev == d) add = 100;
            else add = 600;

            if (costs[ny][nx][d] <= cost + add) continue;
            costs[ny][nx][d] = cost + add;

            DFS(board, nx, ny, cost + add, d, costs);
        }
    }
}