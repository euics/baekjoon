import java.util.*;

class Solution {
    static int ans = 0;

    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> {
            if (a[1] == b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });

        int missile = Integer.MIN_VALUE;
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            if (start >= missile) {
                ans++;
                missile = end;
            }
        }

        return ans;
    }
}