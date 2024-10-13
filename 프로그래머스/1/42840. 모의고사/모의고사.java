import java.util.ArrayList;
import java.util.List;

class Solution {
	static List<Integer> answer = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	static int[] cnt = new int[3];
	private final int[] one = {1, 2, 3, 4, 5};
	private final int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
	private final int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

	public int[] solution(int[] answers) {
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == one[i % 5]) {
				cnt[0]++;
			}

			if (answers[i] == two[i % 8]) {
				cnt[1]++;
			}

			if (answers[i] == three[i % 10]) {
				cnt[2]++;
			}
		}

		max = Math.max(cnt[0], cnt[1]);
		max = Math.max(max, cnt[2]);

		for (int i = 0; i < 3; i++) {
			if (cnt[i] == max) {
				answer.add(i + 1);
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
}