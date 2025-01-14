import java.util.*;

class Solution {
	static int answer = 0;
	static int[] unf;

	public int solution(int n, int[][] costs) {
		Arrays.sort(costs, (a, b) -> a[2] - b[2]);

		unf = new int[n];
		for (int i = 0; i < n; i++) {
			unf[i] = i;
		}

		for (int[] cost : costs) {
			if (find(cost[0]) != find(cost[1])) {
				union(cost[0], cost[1]);

				answer += cost[2];
			}
		}

		return answer;
	}

	public int find(int v) {
		if (v == unf[v]) {
			return unf[v];
		} else {
			return unf[v] = find(unf[v]);
		}
	}

	public void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);

		if (fa != fb) {
			unf[fa] = fb;
		}
	}
}