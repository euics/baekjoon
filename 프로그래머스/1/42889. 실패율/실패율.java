import java.util.*;

class Solution {
	static int[] answer;

	public int[] solution(int N, int[] stages) {
		int[] challenger = new int[N + 2];
		for (int i = 0; i < stages.length; i++) {
			challenger[stages[i]]++;
		}

		FailRate[] failRates = new FailRate[N + 1];
		for (int i = 1; i < N + 1; i++) {
			int cnt = stages.length;

			if(challenger[i] == 0) {
				failRates[i] = new FailRate(0, i);
				continue;
			}

			for (int j = 1; j < i; j++) {
				cnt -= challenger[j];
			}

			failRates[i] = new FailRate((double)challenger[i] / cnt, i);
		}

		Arrays.sort(failRates, 1, N + 1);
		answer = new int[N];
		for (int i = 1; i < N + 1; i++) {
			answer[i - 1] = failRates[i].idx;
		}

		return answer;
	}
}

class FailRate implements Comparable<FailRate> {
	double rate;
	int idx;

	public FailRate(double rate, int idx) {
		this.rate = rate;
		this.idx = idx;
	}

	@Override
	public int compareTo(FailRate o) {
		if (this.rate == o.rate)
			return this.idx - o.idx;
		else
			return Double.compare(o.rate, this.rate);
	}
}