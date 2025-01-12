import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(String[] want, int[] number, String[] discount) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
		}

		if (buyMembership(map, want, number)) {
			answer++;
		}

		if (discount.length > 10) {
			for (int i = 10; i < discount.length; i++) {
				map.put(discount[i - 10], map.get(discount[i - 10]) - 1);
				if (map.get(discount[i - 10]) == 0) {
					map.remove(discount[i - 10]);
				}

				map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);

				if (buyMembership(map, want, number)) {
					answer++;
				}
			}
		}

		return answer;
	}

	public boolean buyMembership(Map<String, Integer> map, String[] want, int[] number) {
		for (int i = 0; i < want.length; i++) {
			if (!map.containsKey(want[i])) {
				return false;
			} else {
				if (map.get(want[i]) < number[i]) {
					return false;
				}
			}
		}

		return true;
	}
}