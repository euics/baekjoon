import java.util.*;

class Solution {
	static int[] answer;

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amounts) {
		Map<String, String> graph = new HashMap<>();
		Map<String, Integer> profit = new HashMap<>();

		for (int i = 0; i < enroll.length; i++) {
			graph.putIfAbsent(enroll[i], referral[i]);
			profit.put(enroll[i], 0);
		}

		for (int i = 0; i < seller.length; i++) {
			int amount = amounts[i] * 100;
			String prev = seller[i];

			while (!prev.equals("-")) {
				int pro = amount / 10;
				profit.put(prev, profit.getOrDefault(prev, 0) + amount - pro);
				prev = graph.get(prev);
				amount = pro;
				
				if(amount < 1) {
					break;
				}
			}
		}

		answer = new int[enroll.length];
		for (int i = 0; i < enroll.length; i++) {
			answer[i] = profit.get(enroll[i]);
		}

		return answer;
	}
}