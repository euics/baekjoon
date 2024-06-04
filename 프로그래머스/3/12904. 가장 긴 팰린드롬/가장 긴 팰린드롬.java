class Solution {
	public int solution(String s) {
		for(int length = s.length(); length >= 1; length--) {

			for(int j = 0; j + length <= s.length(); j++) {

				if(isPalindrome(s, j, j + length - 1)) return length;
			}
		}

		return 0;
	}

	public boolean isPalindrome(String value, int start, int end) {
		while (start <= end) {
			if(value.charAt(start++) != value.charAt(end--)) return false;
		}

		return true;
	}
}