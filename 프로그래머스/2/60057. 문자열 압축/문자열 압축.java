import java.util.*;

class Solution {
    static int ans = 0;

    public int solution(String s) {
        ans = s.length();

        for (int compress = 1; compress <= s.length(); compress++) {
            Queue<String> q = new LinkedList<>();

            for (int idx = 0; idx < s.length(); idx += compress) {
                String substring = s.substring(idx, Math.min(s.length(), idx + compress));
                q.add(substring);
            }

            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                String cur = q.poll();

                int cnt = 1;
                while (!q.isEmpty() && q.peek().equals(cur)) {
                    cnt++;
                    q.poll();
                }

                if (cnt != 1) sb.append(cnt).append(cur);
                else sb.append(cur);
            }

            ans = Math.min(ans, sb.toString().length());
        }

        return ans;
    }
}