import java.util.*;

class Solution {
    public int solution(String s) {
        int min = s.length();
        
        for(int compress = 1; compress <= s.length(); compress++) {
            Queue<String> q = new LinkedList<>();
            
            for(int i = 0; i < s.length(); i += compress) {
                String str = s.substring(i, Math.min(i + compress, s.length()));
                q.add(str);
            }
            
            StringBuilder sb = new StringBuilder();
            
            while(!q.isEmpty()) {
                String cur = q.poll();
                int cnt = 1;
                
                while(!q.isEmpty() && cur.equals(q.peek())) {
                    q.poll();
                    cnt++;
                }
                
                if(cnt == 1) {
                    sb.append(cur);
                } else {
                    sb.append(cnt).append(cur);
                }
            }
            
            min = Math.min(min, sb.toString().length());
        }
        
        return min;
    }
}