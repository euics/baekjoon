class Solution {

	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int range = 2 * w + 1;
		int start = 1;

		for (int station : stations) {
			int left = station - w;

			if (start < left) {
				int gap = left - start;
				answer += (int)Math.ceil((double)gap / range);
			}

			start = station + w + 1;
		}

		if (start <= n) {
			int gap = n - start + 1;
			answer += (int)Math.ceil((double)gap / range);
		}

		return answer;
	}
}