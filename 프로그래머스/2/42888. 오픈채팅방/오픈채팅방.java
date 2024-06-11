import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	static Map<String, String> recordMap = new HashMap<>();

	public String[] solution(String[] record) {
		for (int i = 0; i < record.length; i++) {
			String enterAndExit = record[i].split(" ")[0];

			if (enterAndExit.equals("Enter") || enterAndExit.equals("Change")) {
				String uid = record[i].split(" ")[1];
				String nickName = record[i].split(" ")[2];

				recordMap.put(uid, nickName);
			}
		}

		List<String> answer = new ArrayList<>();
		for (int i = 0; i < record.length; i++) {
			String enterAndExit = record[i].split(" ")[0];

			if (enterAndExit.equals("Enter")) {
				StringBuilder sb = new StringBuilder();
				String uid = record[i].split(" ")[1];
				sb.append(recordMap.get(uid)).append("님이 들어왔습니다.");
				answer.add(sb.toString());
			}

			if (enterAndExit.equals("Leave")) {
				StringBuilder sb = new StringBuilder();
				String uid = record[i].split(" ")[1];
				sb.append(recordMap.get(uid)).append("님이 나갔습니다.");
				answer.add(sb.toString());
			}
		}

		return answer.stream().toArray(String[]::new);
	}
}