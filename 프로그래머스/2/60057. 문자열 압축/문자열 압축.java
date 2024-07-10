import java.util.Stack;

class Solution {
	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution("aabbaccc"));
	}

	public int solution(String s) {
		int n = s.length();
		int minLength = n;

		for (int length = 1; length <= n / 2; length++) {
			StringBuilder compress = new StringBuilder();
			String prev = s.substring(0, length);
			int cnt = 1;

			for (int i = length; i < n; i += length) {
				String cur = s.substring(i, Math.min(i + length, n));

				if (prev.equals(cur))
					cnt++;
				else {
					if (cnt > 1)
						compress.append(cnt).append(prev);
					else
						compress.append(prev);

					prev = cur;
					cnt = 1;
				}
			}

			if (cnt > 1)
				compress.append(cnt).append(prev);
			else
				compress.append(prev);

			minLength = Math.min(compress.toString().length(), minLength);
		}

		return minLength;
	}
}