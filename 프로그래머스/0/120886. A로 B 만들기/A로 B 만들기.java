import java.util.*;

class Solution {
	public int solution(String before, String after) {
		Map<Character, Integer> beforeMap = new HashMap<>();
		Map<Character, Integer> afterMap = new HashMap<>();

		if (before.length() != after.length()) {
			return 0;
		}

		for (int i = 0; i < before.length(); i++) {
			beforeMap.put(before.charAt(i), beforeMap.getOrDefault(before.charAt(i), 0) + 1);
			afterMap.put(after.charAt(i), afterMap.getOrDefault(after.charAt(i), 0) + 1);
		}

		return beforeMap.equals(afterMap) ? 1 : 0;
	}
}