import java.lang.management.OperatingSystemMXBean;
import java.util.*;

class Solution {
	static long max = Integer.MIN_VALUE;

	public long solution(String expression) {
		List<Long> numbers = new ArrayList<>();
		List<Character> operations = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		for (char ch : expression.toCharArray()) {
			if (Character.isDigit(ch))
				sb.append(ch);
			else {
				numbers.add(Long.parseLong(sb.toString()));
				operations.add(ch);
				sb = new StringBuilder();
			}
		}
		numbers.add(Long.parseLong(sb.toString()));

		char[] permutations = new char[3];
		permutation(0, numbers, operations, new char[] {'+', '-', '*'}, permutations, new boolean[3]);

		return max;
	}

	public void permutation(
		int L,
		List<Long> numbers,
		List<Character> operations,
		char[] sequences,
		char[] permutations,
		boolean[] bool
	) {
		if (L == 3) {
			max = Math.max(max, Math.abs(calculate(numbers, operations, permutations)));

			return;
		}

		for (int i = 0; i < 3; i++) {
			if (!bool[i]) {
				bool[i] = true;
				permutations[L] = sequences[i];
				permutation(L + 1, numbers, operations, sequences, permutations, bool);
				bool[i] = false;
			}
		}
	}

	public long calculate(List<Long> numbers, List<Character> operations, char[] permutations) {
		LinkedList<Long> numList = new LinkedList<>(numbers);
		LinkedList<Character> operList = new LinkedList<>(operations);
			
		for (char permutation : permutations) {
			for (int i = 0; i < operList.size(); i++) {
				if (permutation == operList.get(i)) {
					long result = applyOperation(numList.remove(i), numList.remove(i), operList.remove(i));
					numList.add(i, result);
					i--;
				}
			}
		}

		return numList.get(0);
	}

	public long applyOperation(long a, long b, char operation) {
		switch (operation) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			default:
				throw new IllegalStateException("Apply Operation Exception Occur");
		}
	}
}