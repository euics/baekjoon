import java.util.*;

class Solution {
	static ArrayList<String> answer = new ArrayList<>();

	public String[] solution(String[] record) {
		Map<String, String> map = new HashMap<>();

		for (String rec : record) {
			String[] split = rec.split(" ");

			if (split[0].equals("Enter") || split[0].equals("Change")) {
				map.put(split[1], split[2]);
			}
		}

		for (String rec : record) {
			String[] split = rec.split(" ");

			StringBuilder sb = new StringBuilder();
			if (split[0].equals("Enter")) {
				sb.append(map.get(split[1])).append("님이 들어왔습니다.");
			} else if (split[0].equals("Leave")) {
				sb.append(map.get(split[1])).append("님이 나갔습니다.");
			}

			if (!sb.toString().isEmpty()) {
				answer.add(sb.toString());
			}
		}

		return answer.stream().toArray(String[]::new);
	}
}