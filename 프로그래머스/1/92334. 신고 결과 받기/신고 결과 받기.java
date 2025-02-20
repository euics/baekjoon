import java.util.*;
import java.util.stream.Collectors;

class Solution {
	static int[] answer;

	public int[] solution(String[] id_list, String[] report, int k) {
		Map<String, ArrayList<String>> reportMap = new HashMap<>();
		Map<String, Integer> reportedMap = new HashMap<>();

		for (String rep : report) {
			String[] split = rep.split(" ");
			reportMap.putIfAbsent(split[0], new ArrayList<String>());
			reportedMap.putIfAbsent(split[1], 0);

			if (reportMap.get(split[0]).contains(split[1])) {
				continue;
			}

			reportMap.get(split[0]).add(split[1]);
			reportedMap.put(split[1], reportedMap.getOrDefault(split[1], 0) + 1);
		}

		ArrayList<String> ids = new ArrayList<>(Arrays.asList(id_list));
		answer = new int[id_list.length];
		for (String reportedKey : reportedMap.keySet()) {
			if (reportedMap.get(reportedKey) >= k) {
				for (String reportKey : reportMap.keySet()) {
					if (reportMap.get(reportKey).contains(reportedKey)) {
						answer[ids.indexOf(reportKey)]++;
					}
				}
				
			}
		}

		return answer;
	}
}