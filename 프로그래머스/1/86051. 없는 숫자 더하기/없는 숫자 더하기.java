class Solution {
	public int solution(int[] numbers) {
		int sum = sum(numbers);
		return 45 - sum;
	}

	public int sum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}

		return sum;
	}
}