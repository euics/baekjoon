import java.util.*;

class Solution {
	static int[] answer;
	static Map<String, Integer> profitMap = new HashMap<>();
	static Map<String, String> parentMap = new HashMap<>();

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		answer = new int[enroll.length];

		for (int i = 0; i < enroll.length; i++) {
			parentMap.putIfAbsent(enroll[i], referral[i]);
			profitMap.put(enroll[i], 0);
		}

		for (int i = 0; i < seller.length; i++) {
			String cur = seller[i];
			int profit = amount[i] * 100;

			while (!cur.equals("-")) {
				int parentProfit = profit / 10;
				int curProfit = profit - parentProfit;

				profitMap.put(cur, profitMap.getOrDefault(cur, 0) + curProfit);

				cur = parentMap.get(cur);
				profit = parentProfit;

				if (curProfit < 1) {
					break;
				}
			}
		}

		for (int i = 0; i < enroll.length; i++) {
			answer[i] = profitMap.get(enroll[i]);
		}

		return answer;
	}
}