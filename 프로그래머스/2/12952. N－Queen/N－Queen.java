import java.util.*;

class Solution {
    static int ans = 0;
    static int[] permutation;

    public int solution(int n) {
        permutation = new int[n];
        DFS(0, n);

        return ans;
    }

    public void DFS(int row, int n) {
        if (row == n) {
            ans++;

            return;
        }

        for (int col = 0; col < n; col++) {
            permutation[row] = col;

            if (canMove(row)) {
                DFS(row + 1, n);
            }
        }
    }

    public boolean canMove(int row) {
        for (int i = 0; i < row; i++) {
            if (permutation[row] == permutation[i]) return false;
            if (Math.abs(i - row) == Math.abs(permutation[i] - permutation[row])) return false;
        }

        return true;
    }
}