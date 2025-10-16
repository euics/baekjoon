import java.util.*;

class Solution {
    static long ans = 0;

    public long solution(int k, int d) {
        for (int x = 0; x <= d; x += k) {
            int y = (int) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            ans += y / k + 1;
        }

        return ans;
    }
}