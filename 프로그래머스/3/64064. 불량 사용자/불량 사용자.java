import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        boolean[] bool = new boolean[user_id.length];
        DFS(user_id, banned_id, 0, bool, new HashSet<String>());

        return result.size();
    }

    public void DFS(String[] user_id, String[] banned_id, int index, boolean[] bool, Set<String> current) {
        if(index == banned_id.length) {
            result.add(new HashSet<>(current));
            return;
        }

        String pattern = banned_id[index].replace("*", ".");
        for(int i = 0; i < user_id.length; i++) {
            if(!bool[i] && user_id[i].matches(pattern)) {
                bool[i] = true;
                current.add(user_id[i]);
                DFS(user_id, banned_id, index + 1, bool, current);
                bool[i] = false;
                current.remove(user_id[i]);
            }
        }
    }
}