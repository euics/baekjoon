import java.util.*;

class Solution {
	static int leftLength = 0, rightLength = 0;
	static int[] left = new int[] {0, 3};
	static int[] right = new int[] {2, 3};
	static char[][] phone = new char[4][3];
	static HashMap<Character, int[]> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};

	public String solution(int[] numbers, String hand) {
		initPhone();

		for (int number : numbers) {
			if (number == 1 || number == 4 || number == 7) {
				sb.append("L");
				left = map.get(String.valueOf(number).charAt(0));
			} else if (number == 3 || number == 6 || number == 9) {
				sb.append("R");
				right = map.get(String.valueOf(number).charAt(0));
			} else {
				int leftLength = BFS(left, map.get(String.valueOf(number).charAt(0)));
				int rightLength = BFS(right, map.get(String.valueOf(number).charAt(0)));

				if (leftLength < rightLength) {
					sb.append("L");
					left = map.get(String.valueOf(number).charAt(0));
				} else if (leftLength > rightLength) {
					sb.append("R");
					right = map.get(String.valueOf(number).charAt(0));
				} else {
					if (hand.equals("right")) {
						sb.append("R");
						right = map.get(String.valueOf(number).charAt(0));
					} else {
						sb.append("L");
						left = map.get(String.valueOf(number).charAt(0));
					}
				}
			}
		}

		return sb.toString();
	}

	public void initPhone() {
		int num = 1;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				phone[i][j] = String.valueOf(num).charAt(0);
				map.put(String.valueOf(num).charAt(0), new int[] {j, i});
				num++;
			}
		}

		map.put('*', new int[] {0, 3});
		phone[3][0] = '*';
		map.put('0', new int[] {1, 3});
		phone[3][1] = '0';
		map.put('#', new int[] {2, 3});
		phone[3][2] = '#';
	}

	public int BFS(int[] hand, int[] target) {
		Queue<int[]> q = new LinkedList<>();
		q.add(hand);
		boolean[][] bool = new boolean[4][3];
		bool[hand[1]][hand[0]] = true;

		int L = 0;
		while (!q.isEmpty()) {
			int length = q.size();

			for (int i = 0; i < length; i++) {
				int[] cur = q.poll();

				if (cur[0] == target[0] && cur[1] == target[1]) {
					return L;
				}

				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dix[d];
					int ny = cur[1] + diy[d];

					if (nx >= 0 && ny >= 0 && nx < 3 && ny < 4) {
						if (!bool[ny][nx]) {
							q.add(new int[] {nx, ny});
							bool[ny][nx] = true;
						}
					}
				}
			}

			L++;
		}

		return -1;
	}
}