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
            int mid = (max - min) / 2 + min;
            long sum = calculate(diffs, times, mid);

            if (sum > limit) {
                min = mid + 1;
            } else {
                max = mid - 1;
                ans = Math.min(ans, mid);
            }
        }

        return ans;
    }

    public long calculate(int[] diffs, int[] times, int level) {
        long sum = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) sum += times[i];
            else sum += (long) (diffs[i] - level) * (long) (times[i - 1] + times[i]) + (long) times[i];
        }

        return sum;
    }
}