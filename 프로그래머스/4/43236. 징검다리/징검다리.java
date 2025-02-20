import java.util.*;

class Solution {
	static int answer = Integer.MIN_VALUE;

	public int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);

		int min = 1, max = distance;
		while (min <= max) {
			int mid = (min + max) / 2;
			int removed = 0;
			int prev = 0;

			for (int rock : rocks) {
				if (rock - prev < mid) {
					removed++;
				} else {
					prev = rock;
				}
			}

			if (distance - prev < mid) {
				removed++;
			}

			if (removed > n) {
				max = mid - 1;
			} else {
				answer = Math.max(answer, mid);
				min = mid + 1;
			}
		}

		return answer;
	}
}