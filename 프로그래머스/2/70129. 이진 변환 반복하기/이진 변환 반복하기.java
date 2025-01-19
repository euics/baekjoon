import java.util.*;

class Solution {
	static int cnt = 0, loop = 0;

	public int[] solution(String s) {

		while (!s.equals("1")) {
			int zero = 0;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					zero++;
				}
			}

			s = Integer.toString(s.length() - zero, 2);
			loop++;
			cnt += zero;
		}

		return new int[] {loop, cnt};
	}
}