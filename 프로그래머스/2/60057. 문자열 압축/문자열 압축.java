import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;

    public int solution(String s) {
        for (int length = 1; length <= s.length(); length++) {
            String compress = compress(s, length);
            if (min > compress.length()) min = compress.length();
        }

        return min;
    }

    public String compress(String s, int length) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < s.length() - length + 1) {
            String prefix = s.substring(idx, idx + length);
            int cnt = 1;

            for (int j = idx + length; j < s.length() - length + 1; j += length) {
                String suffix = s.substring(j, j + length);
                if (prefix.equals(suffix)) cnt++;
                else break;
            }

            if (cnt == 1) sb.append(prefix);
            else sb.append(cnt).append(prefix);

            idx += cnt * length;
        }

        while (idx < s.length()) sb.append(s.charAt(idx++));
        return sb.toString();
    }
}