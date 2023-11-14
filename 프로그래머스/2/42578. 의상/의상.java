import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int n = clothes.length;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        for(String key : map.keySet()){
            int value = map.get(key);
            answer *= (value + 1);
        }
        
        return answer - 1;
    }
}