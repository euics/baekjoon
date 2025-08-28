import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int ans = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        if (register(map, want, number)) ans++;

        for (int i = 1; i <= discount.length - 10; i++) {
            map.put(discount[i - 1], map.get(discount[i - 1]) - 1);
            map.put(discount[i + 9], map.getOrDefault(discount[i + 9], 0) + 1);
            if (register(map, want, number)) ans++;
        }

        return ans;
    }

    public boolean register(Map<String, Integer> map, String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            if (!map.containsKey(want[i])) {
                return false;
            }

            if (map.get(want[i]) < number[i]) {
                return false;
            }
        }

        return true;
    }
}