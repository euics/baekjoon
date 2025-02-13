import java.util.*;

class Solution {
	public int[] solution(int[] numbers) {
		Set<Integer> set = new TreeSet<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (i == j) {
					continue;
				}

				int sum = numbers[i] + numbers[j];
				set.add(sum);
			}
		}
		
		return set.stream().mapToInt(i -> i).toArray();
	}
}