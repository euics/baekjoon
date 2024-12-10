import java.util.*;

class Solution {
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> stack = new Stack<>();

	public String solution(String number, int k) {
		for (char ch : number.toCharArray()) {
			while (!stack.isEmpty() && k > 0 && stack.peek() < Integer.parseInt(String.valueOf(ch))) {
				stack.pop();
				k--;
			}

			stack.push(Integer.parseInt(String.valueOf(ch)));
		}

		while (k > 0 && !stack.isEmpty()) {
			stack.pop();
			k--;
		}

		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}

		return sb.toString();
	}
}