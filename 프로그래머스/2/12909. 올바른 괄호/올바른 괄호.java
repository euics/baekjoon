import java.util.Stack;

class Solution {
	static Stack<Character> stack = new Stack<>();

	boolean solution(String s) {
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				stack.pop();
			}
		}
		
		return stack.isEmpty() ? true : false;
	}
}