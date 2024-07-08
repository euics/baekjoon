import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public int solution(int n, int k, int[] enemy) {
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int cur : enemy) {
			pq.add(cur);

			if (n - cur >= 0) {
				n -= cur;
			} else {
				if (k > 0) {
					k--;
					n += pq.poll();
					n -= cur;
				} else
					break;
			}

			answer++;
		}

		return answer;
	}
}