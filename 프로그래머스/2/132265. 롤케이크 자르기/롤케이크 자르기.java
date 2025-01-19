import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int[] topping) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < topping.length; i++) {
			map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
		}

		Map<Integer, Integer> a = new HashMap<>();
		for (int i = 0; i < topping.length; i++) {
			map.put(topping[i], map.get(topping[i]) - 1);
			if (map.get(topping[i]) == 0) {
				map.remove(topping[i]);
			}
			a.put(topping[i], a.getOrDefault(topping[i], 0) + 1);
			
			if(a.size() == map.size()) {
				answer++;
			}
		}
		
		return answer;
	}
}