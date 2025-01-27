import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int[] people, int limit) {
		Arrays.sort(people);

		int start = 0, end = people.length - 1;
		while (start <= end) {
			int min = people[start];
			int max = people[end];

			if (min + max <= limit) {
				start++;
			}

			end--;
			answer++;
		}

		return answer;
	}
}