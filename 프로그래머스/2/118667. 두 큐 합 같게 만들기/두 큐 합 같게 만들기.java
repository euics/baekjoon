import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;

		Queue<Integer> q1 = initQueue(queue1);
		Queue<Integer> q2 = initQueue(queue2);

		long sum1 = getSum(q1);
		long sum2 = getSum(q2);

		if ((sum1 + sum2) % 2 != 0)
			return -1;

		while (true) {
			if (answer > (q1.size() + q2.size()) * 2)
				return -1;

			if (sum1 == sum2)
				break;
			else if (sum1 < sum2) {
				sum1 += q2.peek();
				sum2 -= q2.peek();
				q1.add(q2.poll());
			} else {
				sum1 -= q1.peek();
				sum2 += q1.peek();
				q2.add(q1.poll());
			}

			answer++;
		}

		return answer;
	}

	public Queue<Integer> initQueue(int[] queues) {
		Queue<Integer> q = new LinkedList<>();
		for (int queue : queues)
			q.add(queue);

		return q;
	}

	public int getSum(Queue<Integer> q) {
		int sum = 0, length = q.size();
		for (int i = 0; i < length; i++) {
			int cur = q.poll();
			sum += cur;
			q.add(cur);
		}

		return sum;
	}
}