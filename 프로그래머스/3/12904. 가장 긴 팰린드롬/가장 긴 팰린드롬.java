class Solution {
	public int solution(String s) {
		int answer = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (isPalindrome(s, j, i)) {
					answer = Math.max(answer, i - j + 1);
				}
			}
		}

		return answer;
	}

	public boolean isPalindrome(String value, int start, int end) {
		while (start <= end) {
			if (value.charAt(start++) != value.charAt(end--))
				return false;
		}

		return true;
	}
}