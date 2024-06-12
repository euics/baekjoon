import java.util.ArrayList;
import java.util.List;

class Solution {
	public double[] solution(int k, int[][] ranges) {
		double doubleK = (double)k;

		List<Double> sequence = new ArrayList<>();
		sequence.add(doubleK);

		while (doubleK != 1) {
			if (doubleK % 2 == 0) {
				sequence.add(doubleK / 2);
				doubleK /= 2;
			} else {
				sequence.add(doubleK * 3 + 1);
				doubleK = doubleK * 3 + 1;
			}
		}

		List<Double> areas = new ArrayList<>();
		for (int i = 0; i < sequence.size() - 1; i++)
			areas.add((sequence.get(i) + sequence.get(i + 1)) / 2);

		List<Double> answer = new ArrayList<>();
		for (int[] range : ranges) {
			int a = range[0];
			int b = sequence.size() - 1 + range[1];

			if (a > b) {
				answer.add((double)(Math.round(-1.0 * 10) / 10.0));
				continue;
			}

			Double sum = 0.0;
			for (int x = a; x < b; x++)
				sum += areas.get(x);

			answer.add((double)(Math.round(sum * 10) / 10.0));
		}

		return answer.stream().mapToDouble(i -> i).toArray();
	}
}