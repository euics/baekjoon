import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int x, int y, int n) {
		return BFS(x, y, n);
	}

	public int BFS(int x, int y, int n) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] bool = new boolean[y + 1];
		q.add(x);
		bool[x] = true;

		int L = 0;
		while (!q.isEmpty()) {
			int length = q.size();

			for (int i = 0; i < length; i++) {
				int cur = q.poll();

				if (cur == y)
					return L;

				int[] dix = {cur + n, cur * 2, cur * 3};
				for (int d = 0; d < 3; d++) {
					if (dix[d] <= y && !bool[dix[d]]) {
						q.add(dix[d]);
						bool[dix[d]] = true;
					}
				}
			}

			L++;
		}

		return -1;
	}
}