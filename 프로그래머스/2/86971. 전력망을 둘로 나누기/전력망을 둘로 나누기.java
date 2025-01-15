import java.util.*;
import java.io.*;

class Solution {
	static int answer = Integer.MAX_VALUE;
	static int[] unf;

	public int solution(int n, int[][] wires) {
		for (int i = 0; i < wires.length; i++) {
			unf = new int[n + 1];
			for (int j = 0; j <= n; j++) {
				unf[j] = j;
			}

			for (int j = 0; j < wires.length; j++) {
				if (i == j) {
					continue;
				}

				if (find(wires[j][0]) != find(wires[j][1])) {
					union(wires[j][0], wires[j][1]);
				}
			}

			answer = Math.min(answer, Math.abs(rootSize(n) - Math.abs(n - rootSize(n))));
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

	public int rootSize(int n) {
		int root = find(1);
		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			if (find(i) == root) {
				cnt++;
			}
		}

		return cnt;
	}
}