import java.util.*;

public class Solution {
	static int answer = 0;

	public int solution(int n) {
		while (n > 0) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n--;
				answer++;
			}
		}

		return answer;
	}
}