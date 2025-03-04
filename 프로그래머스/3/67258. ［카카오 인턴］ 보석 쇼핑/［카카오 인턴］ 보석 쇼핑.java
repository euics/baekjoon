import java.util.*;

class Solution {
	static int[] answer;

	public int[] solution(String[] gems) {
		answer = new int[2];
		Set<String> set = new HashSet<>(Arrays.asList(gems));

		Map<String, Integer> map = new HashMap<>();
		int start = 0, end = 0, min = Integer.MAX_VALUE;
		while (end < gems.length) {
			map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

			while (start <= end && set.size() == map.keySet().size()) {
				if (end - start + 1 < min) {
					min = end - start + 1;
					answer = new int[] {start + 1, end + 1};
				}

				map.put(gems[start], map.get(gems[start]) - 1);
				if (map.get(gems[start]) == 0) {
					map.remove(gems[start]);
				}

				start++;
			}

			end++;
		}

		return answer;
	}
}