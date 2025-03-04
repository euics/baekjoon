import java.util.*;

class Solution {
	public int[] solution(int n, String[] words) {
		Set<String> set = new HashSet<>();
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < words.length; i++) {
			if ((!stack.isEmpty() && stack.peek().charAt(stack.peek().length() - 1) != words[i].charAt(0))
				|| set.contains(words[i])) {
				return new int[] {i % n + 1, i / n + 1};
			}

			stack.push(words[i]);
			set.add(words[i]);
		}

		return new int[] {0, 0};
	}
}