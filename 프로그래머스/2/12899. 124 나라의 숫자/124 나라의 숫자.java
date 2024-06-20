class Solution {
	public String solution(int n) {
		return change(n, 3);
	}

	public String change(long num, long formation) {
		StringBuilder sb = new StringBuilder();

		while (num > 0) {
			long remain = num % formation;
			num /= formation;

			if (remain == 0) {
				remain = 4;
				num -= 1;
			}

			sb.insert(0, remain);
		}

		return sb.toString();
	}
}