import java.util.*;

class Solution {
    static int ans = Integer.MAX_VALUE;

    public int solution(int[] diffs, int[] times, long limit) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int diff : diffs) {
            min = Math.min(min, diff);
            max = Math.max(max, diff);
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            long calculate = calculate(diffs, times, mid);

            if (calculate > limit) min = mid + 1;
            else {
                max = mid - 1;
                ans = Math.min(ans, mid);
            }
        }

        return ans;
    }

    public long calculate(int[] diffs, int[] times, int level) {
        long calculate = times[0];

        for (int i = 1; i < diffs.length; i++) {
            int diff = diffs[i];
            int time_cur = times[i];
            int time_prev = times[i - 1];

            if (diff <= level) calculate += time_cur;
            else calculate += (long) (diff - level) * (time_cur + time_prev) + time_cur;
        }

        return calculate;
    }
}