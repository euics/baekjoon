class Solution {
	public boolean solution(String s) {
		s = s.toUpperCase();
		return checkAnswer(count(s));
	}

	public int[] count(String s) {
		int[] cnt = new int[2];

		for (char ch : s.toCharArray()) {
			if (ch == 'P') {
				cnt[0]++;
			}

			if (ch == 'Y') {
				cnt[1]++;
			}
		}

		return cnt;
	}

	public boolean checkAnswer(int[] cnt) {
		if (cnt[0] == cnt[1]) {
			return true;
		} else {
			return false;
		}
	}
}