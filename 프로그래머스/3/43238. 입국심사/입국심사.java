import java.util.*;

class Solution {
	static long answer = Long.MAX_VALUE;

	public long solution(int n, int[] times) {
		Arrays.sort(times);

		long start = 1, end = (long)n * times[times.length - 1];
		while (start <= end) {
			long mid = (start + end) / 2;
			long cnt = countN(times, mid);

			if (cnt < n) {
				start = mid + 1;
			} else {
				answer = Math.min(answer, mid);
				end = mid - 1;
			}
		}

		return answer;
	}

	public long countN(int[] times, long mid) {
		long cnt = 0;
		for (int time : times) {
			cnt += mid / time;
		}

		return cnt;
	}
}