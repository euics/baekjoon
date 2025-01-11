import java.util.*;

class Solution {
	public String solution(String[] cards1, String[] cards2, String[] goal) {
		String answer = "";

		Queue<String> card1 = new LinkedList<>(Arrays.asList(cards1));
		Queue<String> card2 = new LinkedList<>(Arrays.asList(cards2));

		for (String word : goal) {
			if (!card1.isEmpty() && card1.peek().equals(word)) {
				card1.poll();
			} else if (!card2.isEmpty() && card2.peek().equals(word)) {
				card2.poll();
			} else {
				return "No";
			}
		}

		return "Yes";
	}
}

/*
 반례입니다.
입력값 〉 ["i", "see", "to"], ["you", "now", "me"], ["i", "see", "now", "me"]
기댓값 〉 "No"
*/