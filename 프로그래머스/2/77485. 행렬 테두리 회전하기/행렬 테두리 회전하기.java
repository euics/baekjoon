class Solution {
	static int[][] arr;
	static int[] result;

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
	}

	public int[] solution(int rows, int columns, int[][] queries) {
		init(rows, columns, queries);

		int index = 0;
		for (int[] query : queries) {
			rotate(--query[1], --query[0], --query[3], --query[2], index++);
		}

		return result;
	}

	public void init(int rows, int columns, int[][] queries) {
		arr = new int[rows][columns];
		result = new int[queries.length];

		for (int i = 0, nums = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++)
				arr[i][j] = nums++;
		}
	}

	public void rotate(int x1, int y1, int x2, int y2, int index) {
		int tmp = arr[y1][x2];
		int min = Integer.MAX_VALUE;

		// 상단 회전
		for (int col = x2; col > x1; col--) {
			min = Math.min(min, arr[y1][col]);
			arr[y1][col] = arr[y1][col - 1];
		}

		// 좌측 회전
		for (int row = y1; row < y2; row++) {
			min = Math.min(min, arr[row][x1]);
			arr[row][x1] = arr[row + 1][x1];
		}

		// 하단 회전
		for (int col = x1; col < x2; col++) {
			min = Math.min(min, arr[y2][col]);
			arr[y2][col] = arr[y2][col + 1];
		}

		// 우측 회전
		for (int row = y2; row > y1; row--) {
			min = Math.min(min, arr[row][x2]);
			arr[row][x2] = arr[row - 1][x2];
		}

		min = Math.min(min, tmp);
		arr[y1 + 1][x2] = tmp;

		result[index] = min;
	}
}