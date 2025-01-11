import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(String s) {
		Deque<Character> dq = new LinkedList<>();
		for (char ch : s.toCharArray()) {
			dq.addLast(ch);
		}

		int x = s.length();
		for (int i = 0; i < x; i++) {
			StringBuilder sb = new StringBuilder();

			for (char ch : dq) {
				sb.append(ch);
			}

			if (correctPattern(sb.toString())) {
				answer++;
			}

			dq.addLast(dq.pollFirst());
		}

		return answer;
	}

	public boolean correctPattern(String s) {
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (ch == '[' || ch == '(' || ch == '{') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					if (matchPattern(stack.peek(), ch)) {
						stack.pop();
					} else {
						return false;
					}
				}
			}
		}

		return stack.isEmpty();
	}

	public boolean matchPattern(char open, char close) {
		return (open == '(' && close == ')') ||
			(open == '[' && close == ']') ||
			(open == '{' && close == '}');
	}
}