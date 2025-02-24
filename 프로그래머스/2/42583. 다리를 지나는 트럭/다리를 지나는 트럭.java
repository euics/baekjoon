import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < bridge_length; i++) {
			bridge.add(0);
		}

		int idx = 0, curWeight = 0;
		while (idx < truck_weights.length) {
			curWeight -= bridge.poll();

			if (curWeight + truck_weights[idx] <= weight) {
				bridge.add(truck_weights[idx]);
				curWeight += truck_weights[idx];
				idx++;
			} else {
				bridge.add(0);
			}

			answer++;
		}

		return answer + bridge.size();
	}
}