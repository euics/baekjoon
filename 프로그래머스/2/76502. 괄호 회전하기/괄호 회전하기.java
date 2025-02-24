import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(String s) {
		Deque<Character> dq = new LinkedList<>();
		for (char ch : s.toCharArray()) {
			dq.addLast(ch);
		}

		for (int rotate = 0; rotate < s.length(); rotate++) {
			if (validate(s)) {
				answer++;
			}

			s = rotate(dq);
		}

		return answer;
	}

	public boolean validate(String s) {
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (ch == '[' || ch == '{' || ch == '(') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				if (ch == ']' && stack.peek() == '[') {
					stack.pop();
				} else if (ch == '}' && stack.peek() == '{') {
					stack.pop();
				} else if (ch == ')' && stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public String rotate(Deque<Character> dq) {
		dq.addLast(dq.pollFirst());

		StringBuilder sb = new StringBuilder();
		int size = dq.size();
		for (int i = 0; i < size; i++) {
			char cur = dq.pollFirst();
			sb.append(cur);
			dq.addLast(cur);
		}

		return sb.toString();
	}
}