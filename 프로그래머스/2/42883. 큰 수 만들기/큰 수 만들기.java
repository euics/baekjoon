import java.util.Stack;

class Solution {
	public String solution(String number, int k) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < number.length(); i++) {
			int cur = Integer.parseInt(String.valueOf(number.charAt(i)));
			while (!stack.isEmpty() && k > 0 && stack.peek() < cur) {
				stack.pop();
				k--;
			}

			stack.push(cur);
		}

		while (!stack.isEmpty() && k > 0) {
			stack.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.insert(0, stack.pop());

		return sb.toString();
	}
}