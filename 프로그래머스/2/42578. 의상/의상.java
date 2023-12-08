import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesInfo = new HashMap<>();
        for(String[] str : clothes){
            String cloth = str[0];
            String clothType = str[1];
            
            clothesInfo.put(clothType, clothesInfo.getOrDefault(clothType, 0) + 1);
        }
        
        int answer = 1;
        for(String keySet : clothesInfo.keySet()){
            answer *= (clothesInfo.get(keySet) + 1);
        }
        
        return answer - 1;
    }
}