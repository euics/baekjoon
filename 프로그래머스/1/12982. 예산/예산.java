import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int[] d, int budget) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int input : d) {
			pq.add(input);
		}

		while (!pq.isEmpty()) {
			int min = pq.poll();

			if (budget > 0 && budget >= min) {
				budget -= min;
				answer++;
			}
		}

		return answer;
	}
}