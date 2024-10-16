import java.util.Arrays;

class Solution {
	public String solution(String s) {
		char[] ch = s.toCharArray();
		Arrays.sort(ch);

		char[] answer = new char[ch.length];
		for (int i = ch.length - 1, idx = 0; i >= 0; i--) {
			answer[idx++] = ch[i];
		}

		return String.valueOf(answer);
	}
}