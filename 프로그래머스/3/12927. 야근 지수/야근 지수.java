import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public long solution(int n, int[] works) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int work : works)
			pq.add(work);

		while (!pq.isEmpty() && n > 0) {
			int cur = pq.poll();
			if (cur - 1 > 0)
				pq.add(cur - 1);
			n--;
		}

		long answer = 0;
		for (int work : pq) {
			System.out.println(work);
			answer += (int)Math.pow(work, 2);
		}

		return answer;
	}
}