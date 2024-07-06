import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public int solution(int[][] data, int col, int row_begin, int row_end) {
		int answer = 0;

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			list.add(new int[data[i].length]);

			for (int j = 0; j < data[i].length; j++) {
				list.get(i)[j] = data[i][j];
			}
		}

		Collections.sort(list, (a, b) -> a[col - 1] == b[col - 1] ? b[0] - a[0] : a[col - 1] - b[col - 1]);

		int[] S = new int[row_end - row_begin + 1];
		for (int i = row_begin - 1, idx = 0; i < row_end; i++) {
			for (int j = 0; j < list.get(i).length; j++) {
				S[idx] += (list.get(i)[j] % (i + 1));
			}
			idx++;
		}

		for (int i = 0; i < S.length; i++) {
			answer ^= S[i];
		}

		return answer;
	}
}