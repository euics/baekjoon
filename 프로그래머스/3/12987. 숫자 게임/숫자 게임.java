import java.util.Arrays;

class Solution {
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		int aIdx = 0, bIdx = 0, score = 0;

		while (bIdx < B.length) {
			if (A[aIdx] < B[bIdx]) {
				aIdx++;
				bIdx++;
				score++;
			} else
				bIdx++;
		}

		return score;
	}
}