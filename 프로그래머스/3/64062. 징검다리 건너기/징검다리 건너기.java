import java.util.*;

class Solution {
    static int ans = 0;

    public int solution(int[] stones, int k) {
        int lo = 0, hi = 0;
        for (int stone : stones) hi = Math.max(hi, stone);

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int cnt = 0;
            boolean canMove = true;
            for (int stone : stones) {
                if (stone - mid < 0) {
                    cnt++;

                    if (cnt >= k) {
                        canMove = false;
                        break;
                    }
                } else {
                    cnt = 0;
                }
            }

            if (canMove) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
}