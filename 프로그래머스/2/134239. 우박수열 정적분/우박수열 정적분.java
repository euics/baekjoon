import java.util.ArrayList;
import java.util.List;

class Solution {
	List<Double> areas = new ArrayList<>();

	public double[] solution(int k, int[][] ranges) {
		int N = findN(k), idx = 0;
		double[] result = new double[ranges.length];
		for (int[] range : ranges) {
			int start = range[0], end = N + range[1];
			if (start > end) {
				result[idx++] = -1;
				continue;
			}

			double sum = 0;
			for (int i = start; i < end; i++)
				sum += areas.get(i);
			result[idx++] = sum;
		}

		return result;
	}

	public int findN(int k) {
		int N = 0, prev = k;

		while (k != 1) {
			if (k % 2 == 0)
				k /= 2;
			else
				k = k * 3 + 1;

			areas.add((double)(k + prev) / 2);
			prev = k;
			N++;
		}

		return N;
	}
}