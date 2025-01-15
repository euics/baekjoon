import java.util.*;
import java.io.*;

class Solution {
	static int answer = 0;
	static int[] permutation;

	public int solution(int n) {
		permutation = new int[n];
		permutation(0, n);

		return answer;
	}

	public void permutation(int row, int n) {
		if (row == n) {
			answer++;

			return;
		}

		for (int col = 0; col < n; col++) {
			permutation[row] = col;

			if (queenRoute(row)) {
				permutation(row + 1, n);
			}
		}
	}

	public boolean queenRoute(int row) {
		for (int i = 0; i < row; i++) {
			if (permutation[i] == permutation[row] || Math.abs(permutation[i] - permutation[row]) == row - i) {
				return false;
			}
		}

		return true;
	}
}