import java.util.*;

class Solution {
	static ArrayList<Integer> answer = new ArrayList<>();

	public int[] solution(String s) {
		String[] split = s.substring(2, s.length() - 2).split("\\},\\{");
		Arrays.sort(split, (a, b) -> a.length() - b.length());

		for (int i = 0; i < split.length; i++) {
			String[] numbers = split[i].split(",");

			for (int j = 0; j < numbers.length; j++) {
				if (!answer.contains(Integer.parseInt(numbers[j]))) {
					answer.add(Integer.parseInt(numbers[j]));
				}
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
}