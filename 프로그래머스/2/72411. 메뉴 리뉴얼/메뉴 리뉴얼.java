import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public String[] solution(String[] orders, int[] course) {
		for (int i = 0; i < orders.length; i++) {
			char[] order = orders[i].toCharArray();
			Arrays.sort(order);
			orders[i] = new String(order);
		}

		Map<String, Integer> map = new HashMap<>();
		for (String order : orders)
			combination(0, order, "", map);

		List<String> answer = new ArrayList<>();
		for (int len : course) {
			List<String> candidate = new ArrayList<>();
			int max = 2;

			for (String combinationKey : map.keySet()) {
				if (len == combinationKey.length() && max <= map.get(combinationKey)) {
					if (max < map.get(combinationKey)) {
						max = map.get(combinationKey);
						candidate.clear();
					}

					candidate.add(combinationKey);
				}
			}

			answer.addAll(candidate);
		}
		
		Collections.sort(answer);

		return answer.stream().toArray(String[]::new);
	}

	public void combination(int L, String order, String cur, Map<String, Integer> map) {
		if (L == order.length()) {
			if (cur.length() >= 2)
				map.put(cur, map.getOrDefault(cur, 0) + 1);

			return;
		}

		combination(L + 1, order, cur + order.charAt(L), map);
		combination(L + 1, order, cur, map);
	}
}