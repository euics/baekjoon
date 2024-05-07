import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> types = new HashSet<>();
        for(String gem : gems) types.add(gem);

        int start = 0, end = 0, minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();

        while(end < gems.length) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while(map.size() == types.size()) {
                if(end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }

                map.put(gems[start], map.get(gems[start]) - 1);
                if(map.get(gems[start]) == 0) map.remove(gems[start]);

                start++;
            }

            end++;
        }

        return answer;
    }
}