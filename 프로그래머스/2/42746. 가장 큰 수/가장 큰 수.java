import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public String solution(int[] numbers) {
		String[] tmp = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			tmp[i] = String.valueOf(numbers[i]);

		Arrays.sort(tmp, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tmp.length; i++)
			sb.append(tmp[i]);

		if (sb.toString().startsWith("0"))
			return "0";
		else
			return sb.toString();
	}
}