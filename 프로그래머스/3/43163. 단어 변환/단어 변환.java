import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(begin);

        int L = 0;
        while(!q.isEmpty()) {
            int length = q.size();

            for(int i = 0; i < length; i++) {
                String cur = q.poll();

                if(cur.equals(target)) return L;

                for(String word : words) {
                    if(!set.contains(word) && canTransform(cur, word)) {
                        set.add(word);
                        q.add(word);
                    }
                }
            }

            L++;
        }
        
        return L;
    }

    public boolean canTransform(String a, String b) {
        int diffCnt = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) diffCnt++;

            if(diffCnt > 1) return false;
        }

        return diffCnt == 1;
    }
}