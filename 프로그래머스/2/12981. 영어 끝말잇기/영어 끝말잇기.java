import java.util.*;

class Solution {
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(
			Arrays.toString(T.solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"}))
		);
	}

	public int[] solution(int n, String[] words) {
		String prev = "", cur = "";

		for (int i = 0; i < words.length / n; i++) {
			for (int j = 0; j < n; j++) {
				cur = words[n * i + j];

				if (i != 0 || j != 0) {
					if (prev.charAt(prev.length() - 1) != cur.charAt(0)) {
						return new int[] {j + 1, i + 1};
					}
				}

				if (set.contains(cur)) {
					return new int[] {j + 1, i + 1};
				} else {
					set.add(cur);
				}

				System.out.printf("%s %s\n", prev, cur);

				prev = cur;
			}
		}

		return new int[] {0, 0};
	}
}