import java.util.Arrays;

class Solution {
	public long solution(int[] sequence) {
		int n = sequence.length;

		long[] pulse1 = new long[n];
		long[] pulse2 = new long[n];

		for(int i = 0; i < n; i++) {
			pulse1[i] = sequence[i] * (i % 2 == 0 ? 1 : -1);
			pulse2[i] = sequence[i] * (i % 2 == 0 ? -1 : 1);
		}

		long maxSum1 = getMaxSubArraySum(pulse1);
		long maxSum2 = getMaxSubArraySum(pulse2);

		return Math.max(maxSum1, maxSum2);
	}

	public long getMaxSubArraySum(long[] arr) {
		long maxSum = arr[0];
		long currentSum = arr[0];

		for(int i = 1; i < arr.length; i++) {
			currentSum = Math.max(arr[i], currentSum + arr[i]);
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}
}