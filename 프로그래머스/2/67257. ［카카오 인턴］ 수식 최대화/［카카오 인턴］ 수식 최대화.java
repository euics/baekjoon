import java.util.*;

class Solution {
	static long answer = Long.MIN_VALUE;
	static char[] permutations = new char[3];
	static char[] oper = new char[] {'+', '*', '-'};

	public long solution(String expression) {
		permutation(expression, 0, new boolean[3]);

		return answer;
	}

	public List<Long> parseNumbers(String expressions) {
		List<Long> numbers = new ArrayList<>();

		String[] formulationNumbers = expressions.split("[-||+||*]");
		for (String formulationNumber : formulationNumbers) {
			formulationNumber = formulationNumber.trim();

			if (!formulationNumber.isEmpty()) {
				numbers.add(Long.parseLong(formulationNumber));
			}
		}

		return numbers;
	}

	public List<Character> parseOperations(String expressions) {
		List<Character> operations = new ArrayList<>();

		String[] formulationOperations = expressions.split("[0-9]");
		for (String formulationOperation : formulationOperations) {
			formulationOperation = formulationOperation.trim();

			if (!formulationOperation.isEmpty()) {
				operations.add(formulationOperation.charAt(0));
			}
		}

		return operations;
	}

	public void permutation(String expressions, int L, boolean[] bool) {
		if (L == 3) {
			List<Long> numbers = parseNumbers(expressions);
			List<Character> operations = parseOperations(expressions);

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

		for (int i = 0; i < 3; i++) {
			if (!bool[i]) {
				bool[i] = true;
				permutations[L] = oper[i];
				permutation(expressions, L + 1, bool);
				bool[i] = false;
			}
		}
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