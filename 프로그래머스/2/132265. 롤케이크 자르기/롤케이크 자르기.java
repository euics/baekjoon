import java.util.HashMap;
import java.util.Map;

class Solution {
	public int solution(int[] topping) {
		Map<Integer, Integer> left = new HashMap<>();
		Map<Integer, Integer> right = new HashMap<>();
		
		for(int i = 0; i < topping.length; i++) right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
		
		int answer = 0;
		for(int top : topping) {
			left.put(top, left.getOrDefault(top, 0) + 1);
			
			if(right.get(top) == 1) right.remove(top);
			else right.put(top, right.get(top) - 1);
			
			if(left.size() == right.size()) answer++;
		}
		
		return answer;
	}
}