import java.util.*;

class Solution {

	public int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);

		int left = 0, right = distance, answer = Integer.MIN_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;
			int remove = 0;

			int pre = 0;
			for(int i = 0; i < rocks.length; i++) {
				if(Math.abs(rocks[i] - pre) < mid) remove++;
				else pre = rocks[i];
			}

			if(Math.abs(distance - pre) < mid) remove++;

			if(remove <= n) {
				answer = Math.max(answer, mid);
				left = mid + 1;
			} else right = mid - 1;
		}
		
		return answer;
	}
}

/*
 0 ~ 2 2 ~ 11 11 ~ 14 14 ~ 17 17 ~ 21 21 ~ 25
 2 9 3 3 4 4

*/