import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothInfo = new HashMap<>();
        for(String[] cloth : clothes) clothInfo.put(cloth[1], clothInfo.getOrDefault(cloth[1], 0) + 1);

        int answer = 1;
        for(String keySet : clothInfo.keySet()) answer *= (clothInfo.get(keySet) + 1);

        return answer - 1;
    }
}