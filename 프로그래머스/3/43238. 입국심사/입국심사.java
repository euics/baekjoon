import java.util.*;

class Solution {
	static long answer = Long.MAX_VALUE;

	public long solution(int n, int[] times) {
		Arrays.sort(times);

		long min = 1, max = (long)n * times[times.length - 1];

		while (min <= max) {
			long mid = (min + max) / 2;
			long cnt = count(times, mid);

			if (cnt >= n) {
				answer = Math.min(answer, mid);
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		return answer;
	}

	public long count(int[] times, long target) {
		long cnt = 0;

		for (int time : times) {
			cnt += (target / time);
		}

		return cnt;
	}
}