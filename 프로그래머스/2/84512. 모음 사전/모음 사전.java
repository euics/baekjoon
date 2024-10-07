import java.util.*;

class Solution {
	static ArrayList<String> dictionary = new ArrayList<>();
	static char[] dfs;

	public int solution(String word) {
		for (int depth = 1; depth <= 5; depth++) {
			dfs = new char[depth];
			dictionary(0, depth, new char[] {'A', 'E', 'I', 'O', 'U'});
		}

		Collections.sort(dictionary);

		return dictionary.indexOf(word) + 1;
	}

	public void dictionary(int L, int depth, char[] vowels) {
		if (L == depth) {
			StringBuilder sb = new StringBuilder();
			for (char x : dfs) {
				sb.append(x);
			}

			dictionary.add(sb.toString());

			return;
		}

		for (int i = 0; i < 5; i++) {
			dfs[L] = vowels[i];
			dictionary(L + 1, depth, vowels);
		}
	}
}