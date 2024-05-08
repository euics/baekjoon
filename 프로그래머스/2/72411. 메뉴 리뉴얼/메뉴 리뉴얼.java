import java.util.*;

class Solution {
    
    public String[] solution(String[] orders, int[] course) {
        for(int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            orders[i] = new String(ch);
        }
        
        Map<String, Integer> map = new HashMap<>();
        for(String order : orders) permutation(order, "", 0, map);
        
        List<String> answer = new ArrayList<>();
        for(int length : course) {
            int max = 2;
            List<String> combination = new ArrayList<>();
            
            for(String key : map.keySet()) {
                
                if(length == key.length() && map.get(key) >= max) {
                    if(max < map.get(key)) {
                        max = map.get(key);
                        combination.clear();
                    }
                    combination.add(key);
                }
            }
            
            answer.addAll(combination);
        }
        
        Collections.sort(answer);
        return answer.stream().toArray(String[]::new);
    }
    
    public void permutation(String orders, String str, int index, Map<String, Integer> map) {
        if(index == orders.length()) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            
            return;
        }
        
        permutation(orders, str + orders.charAt(index), index + 1, map);
        permutation(orders, str, index + 1, map);
    }
}