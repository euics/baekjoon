import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        return BFS(begin, target, words);
    }
    
    public int BFS(String begin, String target, String[] words) {
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        
        boolean[] bool = new boolean[wordList.size()];
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        
        int L = 0;
        while(!q.isEmpty()) {
            int length = q.size();
            
            for(int i = 0; i < length; i++) {
                String cur = q.poll();
                
                if(cur.equals(target)) return L;
                
                for(int d = 0; d < wordList.size(); d++) {
                    if(!bool[d] && compare(cur, wordList.get(d))) {
                        bool[d] = true;
                        q.add(wordList.get(d));
                    }
                }
            }
            
            L++;
        }
        
        return 0;
    }
    
    public boolean compare(String x, String y) {
        if(x.length() != y.length()) return false;
        
        int cnt = 0;
        for(int i = 0; i < x.length(); i++) {
            
            if(x.charAt(i) != y.charAt(i)) cnt++;
        }
        
        return cnt == 1 ? true : false;
    }
}