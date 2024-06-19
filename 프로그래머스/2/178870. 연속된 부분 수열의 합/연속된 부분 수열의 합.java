class Solution {
	public int[] solution(int[] sequence, int k) {
		int[] answer = new int[] {-1, -1};
		int start = 0, end = 0, sum = sequence[0], length = Integer.MAX_VALUE;
		while (end < sequence.length) {
			if (sum < k) {
				end++;

				if (end < sequence.length)
					sum += sequence[end];
			} else if (sum > k)
				sum -= sequence[start++];
			else {
				if (length > end - start + 1) {
					length = end - start + 1;
					answer[0] = start;
					answer[1] = end;
				}

				sum -= sequence[start++];
			}
		}

		return answer;
	}
}