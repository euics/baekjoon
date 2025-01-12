import java.util.*;

class Solution {
	static ArrayList<String> answer = new ArrayList<>();
	static char[] combi;
	static Map<String, Integer> map = new HashMap<>();

	public String[] solution(String[] orders, int[] course) {
		int[] max = new int[course.length];
		Arrays.fill(max, Integer.MIN_VALUE);

		for (int i = 0; i < orders.length; i++) {
			char[] ch = orders[i].toCharArray();
			Arrays.sort(ch);

			orders[i] = new String(ch);
		}

		for (String order : orders) {
			for (int length = 2; length <= order.length(); length++) {
				combi = new char[length];
				combination(0, 0, length, order);
			}
		}

		for (int i = 0; i < course.length; i++) {
			int length = course[i];

			for (String keySet : map.keySet()) {
				if (keySet.length() == length && map.get(keySet) > 1) {
					max[i] = Math.max(max[i], map.get(keySet));
				}
			}

			if (max[i] != Integer.MIN_VALUE) {
				for (String keySet : map.keySet()) {
					if (keySet.length() == length && map.get(keySet) == max[i]) {
						answer.add(keySet);
					}
				}
			}
		}

		Collections.sort(answer);

		return answer.stream().toArray(String[]::new);
	}

	public void combination(int L, int s, int length, String order) {
		if (L == length) {
			StringBuilder sb = new StringBuilder();
			for (char ch : combi) {
				sb.append(ch);
			}

			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);

			return;
		}

		for (int i = s; i < order.length(); i++) {
			combi[L] = order.charAt(i);
			combination(L + 1, i + 1, length, order);
		}
	}
}