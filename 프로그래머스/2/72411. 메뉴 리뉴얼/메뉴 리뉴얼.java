import java.util.*;

class Solution {
	static List<String> answer = new ArrayList<>();
	static Map<String, Integer> candidates = new HashMap<>();

	public String[] solution(String[] orders, int[] course) {
		for (String order : orders) {
			for (int i = 2; i <= order.length(); i++) {
				char[] ch = order.toCharArray();
				Arrays.sort(ch);

				combination(0, i, 0, ch, new char[i]);
			}
		}
		candidates.keySet().removeIf(key -> candidates.get(key) < 2);

		LinkedList<String> keySet = new LinkedList<>(candidates.keySet());
		Collections.sort(keySet, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});

		for (int length : course) {
			int max = Integer.MIN_VALUE;

			for (String key : keySet) {
				if (length == key.length()) {
					max = Math.max(max, candidates.get(key));
				}
			}

			for (String key : keySet) {
				if (length == key.length() && candidates.get(key) == max) {
					answer.add(key);
				}
			}
		}

		Collections.sort(answer);

		return answer.stream().toArray(String[]::new);
	}

	public void combination(int L, int length, int s, char[] order, char[] permutation) {
		if (L == length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < permutation.length; i++) {
				sb.append(permutation[i]);
			}

			candidates.put(sb.toString(), candidates.getOrDefault(sb.toString(), 0) + 1);

			return;
		}

		for (int i = s; i < order.length; i++) {
			permutation[L] = order[i];
			combination(L + 1, length, i + 1, order, permutation);
		}
	}
}