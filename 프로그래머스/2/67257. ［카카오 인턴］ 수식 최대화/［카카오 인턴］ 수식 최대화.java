import java.util.*;

class Solution {

	private static final String[][] precedences = {
		"+-*".split(""),
		"+*-".split(""),
		"*+-".split(""),
		"*-+".split(""),
		"-*+".split(""),
		"-+*".split("")
	};

	static long max = Long.MIN_VALUE;

	public long solution(String expression) {
		List<String> numbers = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(expression, "+-*", true);
		while (st.hasMoreTokens()) {
			numbers.add(st.nextToken());
		}

		for (String[] precedence : precedences) {
			long result = Math.abs(calculate(new ArrayList<>(numbers), precedence));
			max = Math.max(max, result);
		}

		return max;
	}

	public long calculate(List<String> numbers, String[] precedence) {
		for (String operation : precedence) {
			for (int i = 0; i < numbers.size(); i++) {
				if (operation.equals(numbers.get(i))) {
					long a = Long.parseLong(numbers.get(i - 1));
					long b = Long.parseLong(numbers.get(i + 1));
					long result = calculate(a, b, operation);

					numbers.remove(i - 1);
					numbers.remove(i - 1);
					numbers.remove(i - 1);
					numbers.add(i - 1, String.valueOf(result));
					i -= 2;
				}
			}
		}

		return Long.parseLong(numbers.get(0));
	}

	public long calculate(long a, long b, String operation) {
		switch (operation) {
			case "+" -> {
				return a + b;
			}
			case "-" -> {
				return a - b;
			}
			case "*" -> {
				return a * b;
			}
			default -> {
				return 0;
			}
		}
	}
}