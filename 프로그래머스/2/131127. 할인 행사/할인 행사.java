import java.util.*;

class Solution {
	static int answer = 0;
	
	public int solution(String[] want, int[] number, String[] discount) {
		for (int i = 0; i < discount.length - 9; i++) {
			Map<String, Integer> map = new HashMap<>();

			for (int j = i; j < i + 10; j++) {
				map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
			}

			boolean bool = true;
			for (int j = 0; j < want.length; j++) {
				if (!map.containsKey(want[j]) || map.get(want[j]) < number[j]) {
					bool = false;
					break;
				}
			}

			if(bool) {
				answer++;
			}
		}

		return answer;
	}
}