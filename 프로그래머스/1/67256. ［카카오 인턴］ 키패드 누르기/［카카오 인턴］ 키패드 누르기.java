import java.util.*;

class Solution {
	static StringBuilder answer = new StringBuilder();
	static int[][] locations = new int[][] {
		{1, 3},
		{0, 0}, {1, 0}, {2, 0},
		{0, 1}, {1, 1}, {2, 1},
		{0, 2}, {1, 2}, {2, 2}
	};

	static int[] left = new int[] {0, 3};
	static int[] right = new int[] {2, 3};
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};

	public String solution(int[] numbers, String hand) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer.append("L");
				left = locations[numbers[i]];
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer.append("R");
				right = locations[numbers[i]];
			} else {
				int r = distance(right, locations[numbers[i]]);
				int l = distance(left, locations[numbers[i]]);

				if (r > l) {
					answer.append("L");
					left = locations[numbers[i]];
				} else if (r < l) {
					answer.append("R");
					right = locations[numbers[i]];
				} else {
					if (hand.equals("right")) {
						answer.append("R");
						right = locations[numbers[i]];
					} else {
						answer.append("L");
						left = locations[numbers[i]];
					}
				}
			}
		}

		return answer.toString();
	}

	public int distance(int[] src, int[] des) {
		Queue<int[]> q = new LinkedList<>();
		q.add(src);
		boolean[][] bool = new boolean[4][3];
		bool[src[1]][src[0]] = true;

		int L = 0;
		while (!q.isEmpty()) {
			int length = q.size();

			for (int i = 0; i < length; i++) {
				int[] cur = q.poll();

				if (cur[0] == des[0] && cur[1] == des[1]) {
					return L;
				}

				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dix[d];
					int ny = cur[1] + diy[d];

					if (nx >= 0 && ny >= 0 && nx < 3 && ny < 4) {
						if (!bool[ny][nx]) {
							bool[ny][nx] = true;
							q.add(new int[] {nx, ny});
						}
					}
				}
			}

			L++;
		}

		return -1;
	}
}