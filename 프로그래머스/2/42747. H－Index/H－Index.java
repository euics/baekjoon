import java.util.Arrays;
import java.util.Collections;

class Solution {
	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[] {1, 2, 3, 4, 5}));
	}

	public int solution(int[] citations) {
		Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
		Arrays.sort(arr, Collections.reverseOrder());

		int H = arr[0], maxH = Integer.MIN_VALUE;
		while (H >= 0) {
			int cnt = 0;

			for (int citation : citations) {
				if (citation >= H) {
					cnt++;
				}
			}

			if (cnt >= H) {
				maxH = H;
				break;
			}
			
			H--;
		}

		return maxH;
	}
}