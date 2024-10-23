import java.util.HashMap;

class Solution {
	static HashMap<String, Integer> map = new HashMap<>();

	public String solution(String[] participant, String[] completion) {
		for (String s : participant) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		for (String s : completion) {
			map.put(s, map.get(s) - 1);
			if (map.get(s) == 0) {
				map.remove(s);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String key : map.keySet()) {
			sb.append(key);
		}

		return sb.toString();
	}
}