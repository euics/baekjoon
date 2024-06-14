import java.util.Stack;

class Solution {
	public int solution(int[] order) {
		Stack<Integer> subContainer = new Stack<>();
		int cnt = 0, nextBox = 1;

		for (int cur : order) {
			while (nextBox <= cur)
				subContainer.push(nextBox++);

			if (subContainer.peek() == cur) {
				subContainer.pop();
				cnt++;
			} else
				break;
		}
		
		return cnt;
	}
}