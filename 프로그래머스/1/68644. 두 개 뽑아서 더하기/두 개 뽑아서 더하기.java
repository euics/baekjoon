import java.util.Set;
import java.util.TreeSet;

class Solution {
	static Set<Integer> set = new TreeSet<>();
	static int[] permutation = new int[2];

	public int[] solution(int[] numbers) {
		permutation(0, numbers, new boolean[numbers.length]);

		int[] answer = new int[set.size()];
		int idx = 0;
		for (int num : set) {
			answer[idx++] = num;
		}

		return answer;
	}

	public void permutation(int L, int[] numbers, boolean[] bool) {
		if (L == 2) {
			int sum = 0;
			for (int num : permutation) {
				sum += num;
			}
			set.add(sum);

			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!bool[i]) {
				bool[i] = true;
				permutation[L] = numbers[i];
				permutation(L + 1, numbers, bool);
				bool[i] = false;
			}
		}
	}
}