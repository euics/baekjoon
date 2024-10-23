import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
	static int answer = 0;
	static Deque<Character> dq = new LinkedList<>();

	public int solution(String s) {
		for (char ch : s.toCharArray()) {
			dq.addLast(ch);
		}

		int length = dq.size();
		for (int i = 0; i < length; i++) {
			if (isCorrect()) {
				answer++;
			}

			dq.addLast(dq.pollFirst());
		}

		return answer;
	}

	public boolean isCorrect() {
		Deque<Character> tmp = new LinkedList<>(dq);
		Stack<Character> stack = new Stack<>();

		int length = tmp.size();
		for (int i = 0; i < length; i++) {
			char cur = tmp.pollFirst();

			if (cur == '(' || cur == '[' || cur == '{') {
				stack.push(cur);
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				if (cur == ')') {
					if (stack.peek() != '(') {
						return false;
					}
				}

				if (cur == ']') {
					if (stack.peek() != '[') {
						return false;
					}
				}

				if (cur == '}') {
					if (stack.peek() != '{') {
						return false;
					}
				}

				stack.pop();
			}

			tmp.addLast(cur);
		}

		return stack.isEmpty() ? true : false;
	}
}