import java.util.*;

class Solution {
	public int[] solution(int N, int[] stages) {
		int[] reachStage = new int[N + 1];
		int[] notClearStage = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < stages.length; j++) {
				if (stages[j] >= i) {
					reachStage[i]++;
				}

				if (stages[j] == i) {
					notClearStage[i]++;
				}
			}
		}

		Fail[] failureRate = new Fail[N + 1];
		for (int i = 1; i < N + 1; i++) {
			failureRate[i] = new Fail(0f, i);

			if (reachStage[i] == 0) {
				failureRate[i].rate = 0f;
				continue;
			}

			failureRate[i].rate = (float)notClearStage[i] / (float)reachStage[i];
		}

		Arrays.sort(failureRate, 1, N + 1);

		for (int i = 1; i < N + 1; i++) {
			System.out.printf("%f %d\n", failureRate[i].rate, failureRate[i].idx);
		}

		int[] answer = new int[N];
		for (int i = 1; i < N + 1; i++) {
			answer[i - 1] = failureRate[i].idx;
		}

		return answer;
	}
}

class Fail implements Comparable<Fail> {
	float rate;
	int idx;

	public Fail(float rate, int idx) {
		this.rate = rate;
		this.idx = idx;
	}

	@Override
	public int compareTo(Fail o) {
		if (this.rate == o.rate)
			return this.idx - o.idx;
		else
			return Float.compare(o.rate, this.rate);
	}
}