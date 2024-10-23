import java.util.*;

class Solution {
	static int answer = -1;

	public int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);

		int start = 1, end = distance;
		while (start <= end) {
			int mid = (start + end) / 2;
			int remove = 0;

			int prev = 0;
			for (int i = 0; i < rocks.length; i++) {
				if (Math.abs(rocks[i] - prev) < mid) {
					remove++;
				} else {
					prev = rocks[i];
				}
			}

			if (Math.abs(prev - distance) < mid) {
				remove++;
			}

			if (remove <= n) {
				answer = Math.max(answer, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return answer;
	}
}

/*

 0 2 11 14 17 21 25
 0 2 11 14 25
 2 9 3 11

*/