import java.util.*;

class Solution {
	static int[] answer;

	public int[] solution(int[] prices) {
		answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				answer[i]++;

				if (prices[i] > prices[j]) {
					break;
				}
			}
		}

		return answer;
	}
}