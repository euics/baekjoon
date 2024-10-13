class Solution {
	public int[] solution(int brown, int yellow) {
		for (int col = 1; ; col++) {
			for (int row = 1; row <= col; row++) {
				if (col * row == brown + yellow) {
					if (2 * (row + col - 2) == brown) {
						return new int[] {col, row};
					}
				}
			}
		}
	}
}

/*
 가로 A 세로 B

 A * B = BROWN + YELLOW
 2A + 2(B - 2) = BROWN
 2A + 2B - 4
 2(A + B - 2) = BROWN
*/