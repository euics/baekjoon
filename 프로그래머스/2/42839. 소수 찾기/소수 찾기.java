import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(String numbers) {
		int answer = 0;

		Set<Integer> permutation = new HashSet<>();
		permutation("", numbers, permutation);
		for (int num : permutation) {
			if (isPrime(num))
				answer++;
		}
		
		return answer;
	}

	public void permutation(String prefix, String str, Set<Integer> permutation) {
		if (!prefix.equals(""))
			permutation.add(Integer.parseInt(prefix));

		int n = str.length();
		for (int i = 0; i < n; i++)
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), permutation);
	}

	public boolean isPrime(int num) {
		if (num <= 1)
			return false;
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;

		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0)
				return false;
		}

		return true;
	}
}