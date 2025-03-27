import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int[] numbers, int target) {
		DFS(0, numbers, target, 0);
		
		return answer;
	}

	public void DFS(int L, int[] numbers, int target, int sum) {
		if (L == numbers.length) {
			if (sum == target) {
				answer++;
			}

			return;
		}

		DFS(L + 1, numbers, target, sum + numbers[L]);
		DFS(L + 1, numbers, target, sum - numbers[L]);
	}
}