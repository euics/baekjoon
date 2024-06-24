import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int[] solution(String[] gems) {
		int[] answer = new int[2];

		Set<String> types = new HashSet<>();
		for (String gem : gems)
			types.add(gem);

		int start = 0, end = 0, length = Integer.MAX_VALUE;
		Map<String, Integer> map = new HashMap<>();

		while (end < gems.length) {
			map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

			while (map.size() == types.size()) {
				if (end - start + 1 < length) {
					length = end - start + 1;
					answer[0] = start + 1;
					answer[1] = end + 1;
				}

				map.put(gems[start], map.get(gems[start]) - 1);
				if (map.get(gems[start]) == 0)
					map.remove(gems[start]);

				start++;
			}

			end++;
		}

		return answer;
	}
}