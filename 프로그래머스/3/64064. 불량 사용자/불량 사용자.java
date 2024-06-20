import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(String[] user_id, String[] banned_id) {
		DFS(0, user_id, banned_id, new boolean[user_id.length], new HashSet<>());
		return result.size();
	}

	static Set<Set<String>> result = new HashSet<>();

	public void DFS(int L, String[] user_id, String[] banned_id, boolean[] bool, Set<String> cur) {
		if (L == banned_id.length) {
			result.add(new HashSet<>(cur));

			return;
		}

		String pattern = banned_id[L].replace('*', '.');
		for (int i = 0; i < user_id.length; i++) {
			if (!bool[i] && user_id[i].matches(pattern)) {
				bool[i] = true;
				cur.add(user_id[i]);
				DFS(L + 1, user_id, banned_id, bool, cur);
				bool[i] = false;
				cur.remove(user_id[i]);
			}
		}
	}
}