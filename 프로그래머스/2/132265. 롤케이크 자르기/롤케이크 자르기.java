import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int[] topping) {
		Map<Integer, Integer> A = new HashMap<>();
		for (int i = 0; i < topping.length; i++) {
			A.put(topping[i], A.getOrDefault(topping[i], 0) + 1);
		}

		Map<Integer, Integer> B = new HashMap<>();
		for (int i = 0; i < topping.length; i++) {
			B.put(topping[i], B.getOrDefault(topping[i], 0) + 1);
			A.put(topping[i], A.get(topping[i]) - 1);
			
			if (A.get(topping[i]) == 0) {
				A.remove(topping[i]);
			}

			if (A.keySet().size() == B.keySet().size()) {
				answer++;
			}
		}

		return answer;
	}
}