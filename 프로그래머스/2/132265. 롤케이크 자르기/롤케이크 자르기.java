import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(int[] toppings) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for(int topping : toppings) right.put(topping, right.getOrDefault(topping, 0) + 1);

        int answer = 0;
        for(int topping : toppings) {
            left.put(topping, left.getOrDefault(topping, 0) + 1);
            
            if(right.get(topping) == 1) right.remove(topping);
            else right.put(topping, right.get(topping) - 1);
            
            if(left.size() == right.size()) answer++;
        }
        
        return answer;
    }
}