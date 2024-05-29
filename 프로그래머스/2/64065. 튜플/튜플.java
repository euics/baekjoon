import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public int[] solution(String s) {
		String[] split = split(s);

		List<Integer> answer = new ArrayList<>();
		for(String seq : split) {
			String[] num = seq.split(",");
			
			for(int i = 0; i < num.length; i++) {
				if(!answer.contains(Integer.parseInt(num[i]))) answer.add(Integer.parseInt(num[i]));
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	public String[] split(String s) {
		String[] split = s.substring(2, s.length() - 2).split("\\},\\{");
		Arrays.sort(split, (a, b) -> a.length() - b.length());

		return split;
	}
}