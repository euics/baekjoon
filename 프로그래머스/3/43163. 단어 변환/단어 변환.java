import java.util.*;
import java.util.stream.Collectors;

class Solution {
	static int answer = Integer.MAX_VALUE;
	static List<String> list;

	public int solution(String begin, String target, String[] words) {
		list = Arrays.stream(words).collect(Collectors.toList());
		DFS(0, begin, target, words, new boolean[words.length]);

		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	public void DFS(int L, String begin, String target, String[] words, boolean[] bool) {
		if (begin.equals(target)) {
			answer = Math.min(answer, L);

			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (countDiff(begin, words[i])) {
				if (!bool[list.indexOf(words[i])]) {
					bool[list.indexOf(words[i])] = true;
					DFS(L + 1, words[i], target, words, bool);
					bool[list.indexOf(words[i])] = false;
				}
			}
		}
	}

	public boolean countDiff(String o1, String o2) {
		int cnt = 0;

		if (o1.length() != o2.length()) {
			return false;
		}

		for (int i = 0; i < o1.length(); i++) {
			if (o1.charAt(i) != o2.charAt(i)) {
				cnt++;
			}
		}

		return cnt == 1;
	}
}