import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int n, int a, int b) {
		while (a != b) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
			answer++;
		}

		return answer;
	}
}