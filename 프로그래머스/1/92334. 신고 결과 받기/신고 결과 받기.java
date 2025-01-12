import java.util.*;
import java.util.stream.Collectors;

class Solution {
	static int[] answer;
	static Map<String, Set<String>> reportInfo = new HashMap<>();

	public int[] solution(String[] id_list, String[] report, int k) {
		answer = new int[id_list.length];
		ArrayList<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(id_list));

		for (String rep : report) {
			String[] tmp = rep.split(" ");
			reportInfo.putIfAbsent(tmp[1], new HashSet<String>());
			reportInfo.get(tmp[1]).add(tmp[0]);
		}

		for (String keySet : reportInfo.keySet()) {
			if (reportInfo.get(keySet).size() >= k) {
				for (String rep : reportInfo.get(keySet)) {
					answer[list.indexOf(rep)]++;
				}
			}
		}

		return answer;
	}
}