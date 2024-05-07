import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        DFS(user_id, banned_id, new boolean[user_id.length], 0, new HashSet<String>());
        
        return result.size();
    }
    
    static Set<Set<String>> result = new HashSet<>();
    
    public void DFS(String[] user_id, String[] banned_id, boolean[] bool, int index, Set<String> cur) {
        if(index == banned_id.length) {
            result.add(new HashSet<>(cur));
            
            return;
        }
        
        String pattern = banned_id[index].replace("*", ".");
        for(int i = 0; i < user_id.length; i++) {
            if(!bool[i] && user_id[i].matches(pattern)) {
                bool[i] = true;
                cur.add(user_id[i]);
                DFS(user_id, banned_id, bool, index + 1, cur);
                bool[i] = false;
                cur.remove(user_id[i]);
            }
        }
    }
}