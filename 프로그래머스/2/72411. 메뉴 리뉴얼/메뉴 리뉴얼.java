import java.util.*;

class Solution {
	static ArrayList<String> answer = new ArrayList<>();
	static Map<String, Integer> map = new HashMap<>();

	public String[] solution(String[] orders, int[] courses) {
		for (int i = 0; i < orders.length; i++) {
			char[] ch = orders[i].toCharArray();
			Arrays.sort(ch);

			orders[i] = new String(ch);
		}

		for (String order : orders) {
			DFS(0, order, "");
		}

		for (int course : courses) {
			int maxOrder = 2;
			ArrayList<String> candidate = new ArrayList<>();

			for (String keySet : map.keySet()) {
				if (keySet.length() == course) {
					if (map.get(keySet) >= maxOrder) {
						if (map.get(keySet) > maxOrder) {
							candidate.clear();
							maxOrder = map.get(keySet);
						}

						candidate.add(keySet);
					}
				}
			}

			answer.addAll(candidate);
		}

		Collections.sort(answer);

		return answer.stream().toArray(String[]::new);
	}

	public void DFS(int L, String order, String cur) {
		if (L == order.length()) {
			if (cur.length() >= 2) {
				map.put(cur, map.getOrDefault(cur, 0) + 1);
			}

			return;
		}

		DFS(L + 1, order, cur + order.charAt(L));
		DFS(L + 1, order, cur);
	}
}