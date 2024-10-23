import java.util.*;

class Solution {
	static HashMap<Character, Integer> beforeMap = new HashMap<>();
	static HashMap<Character, Integer> afterMap = new HashMap<>();

	public int solution(String before, String after) {
		if (before.length() != after.length()) {
			return 0;
		}

		for (int i = 0; i < before.length(); i++) {
			beforeMap.put(before.charAt(i), beforeMap.getOrDefault(before.charAt(i), 0) + 1);
			afterMap.put(after.charAt(i), afterMap.getOrDefault(after.charAt(i), 0) + 1);
		}
		
		return afterMap.equals(beforeMap) ? 1 : 0;
	}
}