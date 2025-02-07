import java.util.*;

class Solution {
	static final int[][] guesses = {
		{1, 2, 3, 4, 5},
		{2, 1, 2, 3, 2, 4, 2, 5},
		{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
	};

	static List<Integer> answer = new ArrayList<>();

	public int[] solution(int[] answers) {
		int[] cnt = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == guesses[0][i % 5]) {
				cnt[0]++;
			}

			if (answers[i] == guesses[1][i % 8]) {
				cnt[1]++;
			}

			if (answers[i] == guesses[2][i % 10]) {
				cnt[2]++;
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < cnt.length; i++) {
			max = Math.max(max, cnt[i]);
		}

		for (int i = 0; i < cnt.length; i++) {
			if (max == cnt[i]) {
				answer.add(i + 1);
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
}