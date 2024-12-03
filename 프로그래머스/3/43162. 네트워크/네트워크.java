import java.util.*;
import java.io.*;

class Solution {
	static int[] unf;
	static Set<Integer> root = new HashSet<>();

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
					union(i, j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			root.add(find(i));
		}

		return root.size();
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