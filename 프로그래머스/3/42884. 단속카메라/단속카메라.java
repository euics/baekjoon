import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int[][] routes) {
		Arrays.sort(routes, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

		int camera = Integer.MIN_VALUE;
		for (int[] route : routes) {
			if (camera < route[0]) {
				camera = route[1];
				answer++;
			}
		}

		return answer;
	}
}