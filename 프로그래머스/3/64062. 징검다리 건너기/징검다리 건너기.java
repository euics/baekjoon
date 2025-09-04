import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int lo = 0, hi = 0;
        for (int stone : stones) hi = Math.max(hi, stone);

        int answer = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            boolean bool = true;

            for (int stone : stones) {
                if (stone - mid < 0) {
                    cnt++;
                    if (cnt >= k) {
                        bool = false;
                        break;
                    }
                } else {
                    cnt = 0;
                }
            }

            if (!bool) {
                hi = mid - 1;
            } else {
                answer = mid;
                lo = mid + 1;
            }
        }

        return answer;
    }
}