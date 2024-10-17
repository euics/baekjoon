import java.util.*;

class Solution {
	static ArrayList<Integer> answer = new ArrayList<>();
	static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

	public int[] solution(String[] info, String[] queries) {
		for (int i = 0; i < info.length; i++) {
			DFS(0, info[i].split(" "), "");
		}

		for (String keySet : map.keySet()) {
			ArrayList<Integer> value = map.get(keySet);
			Collections.sort(value);
		}

		for (String str : queries) {
			String[] query = str.split(" and ");
			String programming = query[0];
			String occupation = query[1];
			String career = query[2];
			String food = query[3].split(" ")[0];
			int score = Integer.parseInt(query[3].split(" ")[1]);

			StringBuilder sb = new StringBuilder();
			sb.append(programming).append(occupation).append(career).append(food);

			if (!map.containsKey(sb.toString())) {
				answer.add(0);
				continue;
			}

			int idx = binarySearch(map.get(sb.toString()), score);
			if (idx == -1) {
				answer.add(0);
			} else {
				answer.add(map.get(sb.toString()).size() - idx);
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	public void DFS(int L, String[] info, String str) {
		if (L == 4) {
			int score = Integer.parseInt(info[4]);

			map.putIfAbsent(str, new ArrayList<Integer>());
			map.get(str).add(score);

			return;
		}

		DFS(L + 1, info, str + "-");
		DFS(L + 1, info, str + info[L]);
	}

	public int binarySearch(ArrayList<Integer> list, int score) {
		int start = 0, end = list.size() - 1, idx = -1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (list.get(mid) < score) {
				start = mid + 1;
			} else {
				idx = mid;
				end = mid - 1;
			}
		}

		return idx;
	}
}