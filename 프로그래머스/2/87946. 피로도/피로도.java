import java.util.*;
import java.io.*;

class Solution {
	static int answer = 0;
	static int[] dis;

	public int solution(int k, int[][] dungeons) {
		int n = dungeons.length;
		dis = new int[n];

		permutation(0, n, new boolean[n], k, dungeons);

		return answer;
	}

	public void permutation(int L, int n, boolean[] bool, int k, int[][] dungeons) {
		if (L == n) {
			int cnt = 0;

			for (int i = 0; i < n; i++) {
				if (dungeons[dis[i]][0] <= k) {
					k -= dungeons[dis[i]][1];
					cnt++;
				}

				if (k <= 0) {
					break;
				}
			}

			answer = Math.max(answer, cnt);

			return;
		}

		for (int i = 0; i < n; i++) {
			if (!bool[i]) {
				bool[i] = true;
				dis[L] = i;
				permutation(L + 1, n, bool, k, dungeons);
				bool[i] = false;
			}
		}
	}
}