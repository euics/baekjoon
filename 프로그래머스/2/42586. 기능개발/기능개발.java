import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int[] answer;
	static Deque<int[]> q = new LinkedList<>();

	public int[] solution(int[] progresses, int[] speeds) {
		for (int i = 0; i < progresses.length; i++) {
			int remain = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0) {
				remain += 1;
			}

			if (!q.isEmpty() && q.peekLast()[0] >= remain) {
				int[] cur = q.pollLast();
				cur[1]++;
				q.addLast(cur);
			} else {
				q.addLast(new int[] {remain, 1});
			}
		}

		answer = new int[q.size()];
		int idx = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			answer[idx++] = cur[1];
		}

		return answer;
	}
}