import java.util.*;

class Solution {
	static ArrayList<Integer> answer = new ArrayList<>();

	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			int time = -1;

			if ((100 - progresses[i]) % speeds[i] == 0) {
				time = (100 - progresses[i]) / speeds[i];
			} else {
				time = (100 - progresses[i]) / speeds[i] + 1;
			}

			q.add(time);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			int cnt = 1;

			while (!q.isEmpty() && q.peek() <= cur) {
				q.poll();
				cnt++;
			}

			answer.add(cnt);
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
}