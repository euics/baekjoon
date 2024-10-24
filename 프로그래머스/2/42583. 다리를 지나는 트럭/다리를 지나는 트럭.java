import java.util.*;

class Solution {
	static final int EMPTY = 0;
	static Queue<Integer> q = new LinkedList<>();

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		for (int i = 0; i < bridge_length; i++) {
			q.add(EMPTY);
		}

		int idx = 0, bridgeWeight = 0, time = 0;
		while (idx < truck_weights.length) {
			bridgeWeight -= q.poll();

			int curTruckWeight = truck_weights[idx];
			if (bridgeWeight + curTruckWeight <= weight) {
				q.add(curTruckWeight);
				bridgeWeight += curTruckWeight;
				idx++;
			} else {
				q.add(EMPTY);
			}

			time++;
		}

		return time + q.size();
	}
}