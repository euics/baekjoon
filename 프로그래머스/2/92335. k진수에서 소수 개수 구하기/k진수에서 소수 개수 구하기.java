import java.util.*;

class Solution {
	static int answer = 0;
	public int solution(int n, int k) {
		String radix = Integer.toString(n, k);

		int start = 0, end = 0;

		String[] candidate = radix.split("0");
		for (String x : candidate) {
			if(!x.isEmpty() && isPrime(Long.parseLong(x))) {
				answer++;
			}
		}

		return answer;
	}

	public boolean isPrime(long n) {
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		for (long i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}