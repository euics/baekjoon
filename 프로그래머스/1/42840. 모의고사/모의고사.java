import java.util.*;

class Solution {
	static List<Integer> answer = new ArrayList<>();
	static int[][] guess = new int[][] {
		{1, 2, 3, 4, 5},
		{2, 1, 2, 3, 2, 4, 2, 5},
		{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
	};

	public int[] solution(int[] answers) {
		int[] cnt = new int[3];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == guess[0][i % 5]) {
				cnt[0]++;
			}

			if (answers[i] == guess[1][i % 8]) {
				cnt[1]++;
			}

			if (answers[i] == guess[2][i % 10]) {
				cnt[2]++;
			}
		}

		max = Math.max(max, Math.max(Math.max(cnt[0], cnt[1]), cnt[2]));

		for (int i = 0; i < 3; i++) {
			if (cnt[i] == max) {
				answer.add(i + 1);
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
}