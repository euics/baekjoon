import java.util.*;

class Solution {
	static Map<String, Integer> map = new HashMap<>();

	public String solution(String[] participant, String[] completion) {
		for (String par : participant) {
			map.put(par, map.getOrDefault(par, 0) + 1);
		}

		for (String com : completion) {
			map.put(com, map.get(com) - 1);

			if (map.get(com) == 0) {
				map.remove(com);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String key : map.keySet()) {
			sb.append(key);
		}

		return sb.toString();
	}
}