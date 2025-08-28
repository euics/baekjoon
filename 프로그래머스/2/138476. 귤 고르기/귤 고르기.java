import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> size = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) size.put(tangerine[i], size.getOrDefault(tangerine[i], 0) + 1);

        LinkedList<Integer> sortedKeys = new LinkedList<>(size.keySet());
        Collections.sort(sortedKeys, (a, b) -> size.get(b) - size.get(a));
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0, cnt = 0; i < sortedKeys.size(); i++) {
            if (cnt >= k) break;
            cnt += size.get(sortedKeys.get(i));
            set.add(sortedKeys.get(i));
        }

        return set.size();
    }
}