import java.util.Arrays;
import java.util.Collections;

class Solution {
	public int solution(int[] citations) {
		Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
		Arrays.sort(tmp, Collections.reverseOrder());

		int h = tmp[0], maxH = Integer.MIN_VALUE;
		while (h >= 0) {
			int cnt = 0;

			for (int citation : citations) {
				if (citation >= h)
					cnt++;
			}

			if (cnt >= h) {
				maxH = h;
				break;
			}
			
			h--;
		}

		return maxH;
	}
}