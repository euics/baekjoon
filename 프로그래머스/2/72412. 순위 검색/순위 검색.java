import java.util.*;

class Solution {
	static int[] answer;
	static Map<String, ArrayList<Integer>> map = new HashMap<>();

	public int[] solution(String[] info, String[] query) {
		for (int i = 0; i < info.length; i++) {
			String[] split = info[i].split(" ");
			String[] conditions = new String[] {split[0], split[1], split[2], split[3]};
			int score = Integer.parseInt(split[4]);

			combination(0, conditions, score, "");
		}

		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}

		answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			String[] split = query[i].replace(" and ", " ").split(" ");
			String key = split[0] + split[1] + split[2] + split[3];
			int target = Integer.parseInt(split[4]);

			if (map.containsKey(key)) {
				int idx = binarySearch(map.get(key), target);
				answer[i] = idx;
			} else {
				answer[i] = 0;
			}
		}

		return answer;
	}

	public void combination(int L, String[] conditions, int score, String key) {
		if (L == 4) {
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(score);

			return;
		}

		combination(L + 1, conditions, score, key + conditions[L]);
		combination(L + 1, conditions, score, key + "-");
	}

	public int binarySearch(List<Integer> scores, int target) {
		int left = 0, right = scores.size() - 1, idx = scores.size();

		while (left <= right) {
			int mid = (left + right) / 2;

			if (scores.get(mid) >= target) {
				idx = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return scores.size() - idx;
	}
}