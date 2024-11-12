import java.util.*;

class Solution {
	public int solution(int[][] jobs) {
		Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		int idx = 0, cnt = 0, sum = 0, end = 0;
		while (cnt < jobs.length) {

			while (idx < jobs.length && jobs[idx][0] <= end) {
				pq.add(jobs[idx++]);
			}

			if (pq.isEmpty()) {
				end = jobs[idx][0];
			} else {
				int[] cur = pq.poll();
				sum += end + cur[1] - cur[0];
				end += cur[1];
				cnt++;
			}
		}

		return sum / jobs.length;
	}
}