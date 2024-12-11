import java.util.*;
import java.util.stream.Collectors;

class Solution {
	static int[] answer;
	static HashMap<String, Set<String>> reportInfo = new HashMap<>();

	public int[] solution(String[] id_list, String[] report, int k) {
		List<String> list = Arrays.stream(id_list).collect(Collectors.toList());
		answer = new int[id_list.length];

		for (int i = 0; i < report.length; i++) {
			String from = report[i].split(" ")[0];
			String to = report[i].split(" ")[1];

			reportInfo.putIfAbsent(to, new HashSet<String>());
			reportInfo.get(to).add(from);
		}

		for (String key : reportInfo.keySet()) {
			if (reportInfo.get(key).size() >= k) {
				for (String set : reportInfo.get(key)) {
					answer[list.indexOf(set)]++;
				}
			}
		}

		return answer;
	}
}