import java.util.*;

class Solution {
    static int ans = Integer.MIN_VALUE;

    public int solution(String s) {
        for (int end = s.length() - 1; end >= 0; end--) {
            for (int start = 0; start <= end; start++) {
                if (palindrome(s, start, end)) {
                    ans = Math.max(ans, end - start + 1);
                }
            }
        }

        return ans;
    }

    public boolean palindrome(String s, int start, int end) {
        while (start <= end) if (s.charAt(start++) != s.charAt(end--)) return false;

        return true;
    }
}