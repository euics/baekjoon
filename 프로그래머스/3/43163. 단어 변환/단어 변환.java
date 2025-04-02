import java.util.*;

class Solution {
	static int min = Integer.MAX_VALUE;

	public int solution(String begin, String target, String[] words) {
		DFS(0, begin, target, words, new boolean[words.length]);

		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public void DFS(int L, String begin, String target, String[] words, boolean[] bool) {
		if (min < L) {
			return;
		}

		if (begin.equals(target)) {
			min = L;
		}

		for (int i = 0; i < words.length; i++) {
			if (diff(begin, words[i])) {
				if (!bool[i]) {
					bool[i] = true;
					DFS(L + 1, words[i], target, words, bool);
					bool[i] = false;
				}
			}
		}
	}

	public boolean diff(String begin, String word) {
		int cnt = 0;

		if (begin.length() != word.length()) {
			return false;
		}

		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) != word.charAt(i)) {
				cnt++;
			}
		}

		return cnt == 1;
	}
}