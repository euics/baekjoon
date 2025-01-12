import java.util.*;

class Solution {
	static ArrayList<String> answer = new ArrayList<>();
	static Map<String, String> map = new HashMap<>();

	public String[] solution(String[] record) {
		for (String rec : record) {
			String[] info = rec.split(" ");

			if (info[0].equals("Enter")) {
				map.put(info[1], info[2]);
			} else if (info[0].equals("Change")) {
				map.put(info[1], info[2]);
			}
		}

		for (String rec : record) {
			String[] info = rec.split(" ");

			if (info[0].equals("Enter")) {
				answer.add(map.get(info[1]) + "님이 들어왔습니다.");
			} else if (info[0].equals("Leave")) {
				answer.add(map.get(info[1]) + "님이 나갔습니다.");
			}
		}

		return answer.toArray(new String[0]);
	}
}