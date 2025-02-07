import java.util.*;

class Solution {
	public int solution(String numbers) {
		Set<Integer> set = new HashSet<>();
		permutation("", numbers, set);

		return (int)set.stream().filter(this::isPrime).count();
	}

	public void permutation(String prefix, String str, Set<Integer> set) {
		if (!prefix.isEmpty()) {
			set.add(Integer.parseInt(prefix));
		}

		int n = str.length();
		for (int i = 0; i < n; i++) {
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
		}
	}

	public boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}