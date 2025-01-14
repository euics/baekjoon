import java.util.*;

class Solution {
	static int[] unf;

	public int solution(int n, int[][] computers) {
		unf = new int[n];
		for (int i = 0; i < n; i++) {
			unf[i] = i;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}

				if (computers[i][j] == 1) {
					if (find(i) != find(j)) {
						union(i, j);
					}
				}
			}
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(find(i));
		}

		return set.size();
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