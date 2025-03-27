import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int n, int[] lost, int[] reserve) {
		int[] arr = new int[n + 1];
		Arrays.fill(arr, 1);
		for (int j : lost) {
			arr[j]--;
		}
		for (int j : reserve) {
			arr[j]++;
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i] > 1 && i - 1 >= 1 && arr[i - 1] == 0) {
				arr[i - 1]++;
				arr[i]--;
			}

			if (arr[i] > 1 && i + 1 <= n && arr[i + 1] == 0) {
				arr[i + 1]++;
				arr[i]--;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i] >= 1) {
				answer++;
			}
		}

		return answer;
	}
}