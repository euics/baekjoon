import java.util.*;

class Solution {
    static int ans = 0;
    static int[] permutation;

    public int solution(int n) {
        permutation = new int[n];
        permutation(0, n);

        return ans;
    }

    public void permutation(int L, int n) {
        if (L == n) {
            ans++;

            return;
        }

        for (int col = 0; col < n; col++) {
            permutation[L] = col;
            if (!conflict(L)) permutation(L + 1, n);
        }
    }

    public boolean conflict(int row) {
        for (int i = 0; i < row; i++) {
            if (permutation[i] == permutation[row]) return true;
            if (Math.abs(permutation[i] - permutation[row]) == Math.abs(row - i)) return true;
        }

        return false;
    }
}