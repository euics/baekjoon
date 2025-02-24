import java.util.*;

class Solution {
	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				if (stack.peek() == '(') {
					stack.pop();
				}
			}
		}

		return stack.isEmpty();
	}
}