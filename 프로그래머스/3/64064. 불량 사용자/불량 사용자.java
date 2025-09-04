import java.util.*;

class Solution {
    static Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        matches(0, user_id, banned_id, new HashSet<>());

        return result.size();
    }

    public void matches(int L, String[] user_id, String[] banned_id, Set<String> set) {
        if (L == banned_id.length) {
            result.add(new HashSet<>(set));

            return;
        }

        String pattern = banned_id[L].replace("*", ".");
        for (int i = 0; i < user_id.length; i++) {
            if (user_id[i].matches(pattern) && !set.contains(user_id[i])) {
                set.add(user_id[i]);
                matches(L + 1, user_id, banned_id, set);
                set.remove(user_id[i]);
            }
        }
    }
}