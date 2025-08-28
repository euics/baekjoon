import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] ans = new int[(int) (right - left) + 1];
        for (long i = left, idx = 0; i <= right; i++) {
            int row = (int) (i / n);
            int col = (int) (i % n);

            ans[(int) idx++] = Math.max(row, col) + 1;
        }

        return ans;
    }
}