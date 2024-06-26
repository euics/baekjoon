class Solution {
	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;

		int aGCD = getGCDs(arrayA);
		int bGCD = getGCDs(arrayB);
		if (checkRemain(arrayA, bGCD))
			answer = Math.max(answer, bGCD);
		if (checkRemain(arrayB, aGCD))
			answer = Math.max(answer, aGCD);

		return answer;
	}

	public int getGCD(int num1, int num2) {
		if (num1 % num2 == 0)
			return num2;

		return getGCD(num2, num1 % num2);
	}

	public int getGCDs(int[] arr) {
		int result = arr[0];
		for (int i = 1; i < arr.length; i++)
			result = getGCD(result, arr[i]);

		return result;
	}

	public boolean checkRemain(int[] arr, int gcd) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % gcd == 0)
				return false;
		}

		return true;
	}
}