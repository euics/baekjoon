import java.util.*;

class Solution {
	static int[] answer;
	static ArrayList<String> idInfo = new ArrayList<>();
	static Map<String, Set<String>> reportInfo = new HashMap<>();
	static Map<String, Integer> reported = new HashMap<>();

	public int[] solution(String[] id_list, String[] report, int k) {
		answer = new int[id_list.length];
		idInfo.addAll(Arrays.asList(id_list));

		for (String rep : report) {
			String[] tmp = rep.split(" ");
			reportInfo.putIfAbsent(tmp[0], new HashSet<String>());
			reportInfo.get(tmp[0]).add(tmp[1]);
		}

		for (String keySet : reportInfo.keySet()) {
			Set<String> rep = reportInfo.get(keySet);

			for (String s : rep) {
				reported.put(s, reported.getOrDefault(s, 0) + 1);
			}
		}

		for (String keySet : reported.keySet()) {
			if (reported.get(keySet) >= k) {
				for (String rep : reportInfo.keySet()) {
					if (reportInfo.get(rep).contains(keySet)) {
						answer[idInfo.indexOf(rep)]++;
					}
				}
			}
		}

		return answer;
	}
}