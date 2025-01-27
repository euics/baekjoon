import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int k, int[] tangerine) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int type : tangerine) {
			map.put(type, map.getOrDefault(type, 0) + 1);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for (int keySet : map.keySet()) {
			pq.add(new int[] {keySet, map.get(keySet)});
		}

		while (!pq.isEmpty() && k > 0) {
			int[] cur = pq.poll();

			if (cur[1] <= k) {
				k -= cur[1];
			} else {
				k = 0;
			}

			answer++;
		}

		return answer;
	}
}