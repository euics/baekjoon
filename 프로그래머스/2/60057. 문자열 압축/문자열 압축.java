class Solution {
	public int solution(String s) {
		int n = s.length();
		int minLength = n;

		for(int unit = 1; unit <= n / 2; unit++) {
			String compressed = "";
			String prev = s.substring(0, unit);
			int cnt = 1;

			for(int i = unit; i < n; i += unit) {
				String cur = s.substring(i, Math.min(i + unit, n));
				if(prev.equals(cur)) cnt++;
				else {
					if(cnt > 1) compressed += cnt + prev;
					else compressed += prev;

					prev = cur;
					cnt = 1;
				}
			}

			if(cnt > 1) compressed += cnt + prev;
			else compressed += prev;

			minLength = Math.min(minLength, compressed.length());
		}

		return minLength;
	}
}