import java.util.*;

class Solution {
	public String solution(int[] numbers) {
		String[] str = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String value : str) {
			sb.append(value);
		}

		return sb.toString().startsWith("0") ? "0" : sb.toString();
	}
}