import java.util.*;

class Solution {
	static String answer = "";

	public String solution(String number, int k) {
		Stack<Integer> stack = new Stack<>();
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
			answer = stack.pop() + answer;
		}

		return answer;
	}
}