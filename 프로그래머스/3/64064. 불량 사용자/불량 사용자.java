import java.util.HashSet;
import java.util.Set;

class Solution {
	static Set<Set<String>> result = new HashSet<>();

	public int solution(String[] user_id, String[] banned_id) {
		DFS(0, user_id, banned_id, new HashSet<String>());

		return result.size();
	}

	public void DFS(int L, String[] user_id, String[] banned_id, Set<String> set) {
		if (L == banned_id.length) {
			result.add(new HashSet<>(set));

			return;
		}

		String pattern = banned_id[L].replace("*", ".");
		for (int i = 0; i < user_id.length; i++) {
			if (user_id[i].matches(pattern) && !set.contains(user_id[i])) {
				set.add(user_id[i]);
				DFS(L + 1, user_id, banned_id, set);
				set.remove(user_id[i]);
			}
		}
	}
}