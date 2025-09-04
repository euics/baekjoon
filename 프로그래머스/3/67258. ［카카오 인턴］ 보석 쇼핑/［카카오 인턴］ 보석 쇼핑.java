import java.util.*;

class Solution {
    static int[] ans = new int[2];

    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();

        int start = 0, end = 0, minLength = Integer.MAX_VALUE;
        while (start < gems.length && end < gems.length) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (start <= end && map.size() == set.size()) {
                int curLength = end - start + 1;
                if (curLength < minLength) {
                    minLength = curLength;
                    ans[0] = start + 1;
                    ans[1] = end + 1;
                }

                map.put(gems[start], map.getOrDefault(gems[start], 0) - 1);
                if (map.get(gems[start]) == 0) map.remove(gems[start]);
                start++;
            }

            end++;
        }

        return ans;
    }
}