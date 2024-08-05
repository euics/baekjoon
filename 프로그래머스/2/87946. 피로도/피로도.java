class Solution {
	static int[] dis;
	static int answer = Integer.MIN_VALUE;

	public int solution(int k, int[][] dungeons) {
		dis = new int[dungeons.length];
		DFS(k, dungeons, 0, new boolean[dungeons.length]);

		return answer;
	}

	public void DFS(int k, int[][] dungeons, int L, boolean[] bool) {
		if (L == dungeons.length) {
			answer = Math.max(answer, countPassDungeons(k, dungeons));

			return;
		}

		for (int i = 0; i < dungeons.length; i++) {
			if (!bool[i]) {
				bool[i] = true;
				dis[L] = i;
				DFS(k, dungeons, L + 1, bool);
				bool[i] = false;
			}
		}
	}

	public int countPassDungeons(int k, int[][] dungeons) {
		int cnt = 0;
		for (int idx : dis) {
			if (k <= 0 || k < dungeons[idx][0])
				break;

			k -= dungeons[idx][1];
			cnt++;
		}

		return cnt;
	}
}