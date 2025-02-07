import java.util.*;

class Solution {
	static long answer = Long.MIN_VALUE;
	static char[] permutations = new char[3];
	static char[] operations = {'+', '-', '*'};

	public long solution(String expression) {
		permutation(expression, 0, new boolean[3]);

		return answer;
	}

	public void permutation(String expression, int L, boolean[] bool) {
		if (L == 3) {
			List<Long> numbers = parseNumbers(expression);
			List<Character> operations = parseOperations(expression);

			for (char permutation : permutations) {
				int p = 0;

				while (p < operations.size()) {
					if (operations.get(p) == permutation) {
						long result = calculate(numbers.get(p), numbers.get(p + 1), permutation);
						numbers.set(p, result);
						numbers.remove(p + 1);
						operations.remove(p);
					} else {
						p++;
					}
				}
			}

			answer = Math.max(answer, Math.abs(numbers.get(0)));

			return;
		}

		for (int i = 0; i < operations.length; i++) {
			if (!bool[i]) {
				bool[i] = true;
				permutations[L] = operations[i];
				permutation(expression, L + 1, bool);
				bool[i] = false;
			}
		}
	}

	public List<Long> parseNumbers(String expression) {
		List<Long> numbers = new ArrayList<>();

		String[] formulationNumbers = expression.split("[-||+||*]");
		for (String formulationNumber : formulationNumbers) {
			formulationNumber = formulationNumber.trim();

			if (!formulationNumber.isEmpty()) {
				numbers.add(Long.parseLong(formulationNumber));
			}
		}

		return numbers;
	}

	public List<Character> parseOperations(String expression) {
		List<Character> operations = new ArrayList<>();

		String[] formulationOperations = expression.split("[0-9]");
		for (String formulationOperation : formulationOperations) {
			formulationOperation = formulationOperation.trim();

			if (!formulationOperation.isEmpty()) {
				operations.add(formulationOperation.charAt(0));
			}
		}

		return operations;
	}

	public long calculate(long a, long b, char permutation) {
		return switch (permutation) {
			case '+' -> a + b;
			case '-' -> a - b;
			case '*' -> a * b;
			default -> throw new IllegalArgumentException("calculate Method Error");
		};
	}
}