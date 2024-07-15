class Solution {
	public long solution(int[] sequence) {
		int n = sequence.length;

		long[] purse1 = new long[n];
		long[] purse2 = new long[n];
		for (int i = 0; i < n; i++) {
			purse1[i] = sequence[i] * (i % 2 == 0 ? 1 : -1);
			purse2[i] = sequence[i] * (i % 2 == 0 ? -1 : 1);
		}

		long maxSum1 = KadaneAlgorithm(purse1);
		long maxSum2 = KadaneAlgorithm(purse2);

		return Math.max(maxSum1, maxSum2);
	}

	public long KadaneAlgorithm(long[] arr) {
		long maxSum = arr[0];
		long currentSum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			currentSum = Math.max(arr[i], currentSum + arr[i]);
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}
}