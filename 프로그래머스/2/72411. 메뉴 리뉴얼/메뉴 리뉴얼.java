import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            orders[i] = new String(ch);
        }

        for(String order : orders) combination(order, "", 0, map);

        List<String> answer = new ArrayList<>();
        for(int len : course) {
            List<String> candidates = new ArrayList<>();
            int max = 2;

            for(String combinationKey : map.keySet()) {
                if(len == combinationKey.length() && map.get(combinationKey) >= max) {
                    if(map.get(combinationKey) > max) {
                        max = map.get(combinationKey);
                        candidates.clear();
                    }

                    candidates.add(combinationKey);
                }
            }

            answer.addAll(candidates);
        }

        Collections.sort(answer);
        return answer.stream().toArray(String[]::new);
    }

    public void combination(String order, String current, int index, Map<String, Integer> map) {
        if(index == order.length()) {
            if(current.length() >= 2) {
                map.put(current, map.getOrDefault(current, 0) + 1);
            }

            return;
        }

        combination(order, current + order.charAt(index), index + 1, map);
        combination(order, current, index + 1, map);
    }
}