import java.util.*;

class Solution {
	static ArrayList<Integer> answer = new ArrayList<>();

	public int[] solution(int[] progresses, int[] speeds) {
		int[] remains = new int[progresses.length];
		for (int i = 0; i < progresses.length; i++) {
			remains[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
		}

		int start = 0, end = 0, cnt = 0;
		while (end < progresses.length) {
			if (remains[start] >= remains[end]) {
				cnt++;
				end++;
			} else {
				answer.add(cnt);
				start = end;
				cnt = 0;
			}
		}

		answer.add(cnt);
		return answer.stream().mapToInt(i -> i).toArray();
	}
}