import java.util.*;

class Solution {
	static List<Integer> answer = new ArrayList<>();

	public int[] solution(String s) {
		String[] str = s.substring(2, s.length() - 2).split("\\},\\{");
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		for (String string : str) {
			String[] tmp = string.split(",");

			for (int i = 0; i < tmp.length; i++) {
				if (!answer.contains(Integer.parseInt(tmp[i]))) {
					answer.add(Integer.parseInt(tmp[i]));
				}
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
}