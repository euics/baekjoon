import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(String[] maps) {
		init(maps);

		int minLever = BFS(maps, start[0], start[1], lever[0], lever[1]);
		if(minLever == -1) return -1;

		int minEnd = BFS(maps, lever[0], lever[1], end[0], end[1]);
		if(minEnd == -1) return -1;

		return minLever + minEnd;
	}

	static int[] start = new int[2];
	static int[] lever = new int[2];
	static int[] end = new int[2];

	public void init(String[] maps) {
		for(int i = 0; i < maps.length; i++) {
			for(int j = 0; j < maps[i].length(); j++) {
				if(maps[i].charAt(j) == 'S') {
					start[0] = j;
					start[1] = i;
				}

				if(maps[i].charAt(j) == 'L') {
					lever[0] = j;
					lever[1] = i;
				}

				if(maps[i].charAt(j) == 'E') {
					end[0] = j;
					end[1] = i;
				}
			}
		}
	}

	static int[] dix = {0, 0, -1, 1};
	static int[] diy = {-1, 1, 0, 0};

	public int BFS(String[] maps, int startX, int startY, int endX, int endY) {
		int n = maps.length;
		int m = maps[0].length();

		boolean[][] bool = new boolean[maps.length][maps[0].length()];
		bool[startY][startX] = true;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{startX, startY});

		int L = 0;
		while(!q.isEmpty()) {
			int length = q.size();

			for(int i = 0; i < length; i++) {
				int[] cur = q.poll();

				if(cur[0] == endX && cur[1] == endY) return L;

				for(int d = 0; d < 4; d++) {
					int nx = cur[0] + dix[d];
					int ny = cur[1] + diy[d];

					if(nx >= 0 && ny >= 0 && nx < m && ny < n && maps[ny].charAt(nx) != 'X') {
						if(!bool[ny][nx]) {
							bool[ny][nx] = true;
							q.add(new int[]{nx, ny});
						}
					}
				}
			}

			L++;
		}

		return -1;
	}
}