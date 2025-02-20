import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int[] numbers) {
		boolean[] bool = new boolean[10];
		for (int number : numbers) {
			bool[number] = true;
		}

		for (int i = 0; i < 10; i++) {
			if (!bool[i]) {
				answer += i;
			}
		}

		return answer;
	}
}