import java.util.*;

class Solution {
    static int ans = 0;

    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int missile = Integer.MIN_VALUE;
        for (int i = 0; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];

            if (s >= missile) {
                ans++;
                missile = e;
            }
        }

        return ans;
    }
}