import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = initQueue(queue1);
        Queue<Integer> q2 = initQueue(queue2);
        long sum1 = findSum(queue1);
        long sum2 = findSum(queue2);

        if ((sum1 + sum2) % 2 != 0) return -1;

        while (true) {
            if (answer > (q1.size() + q2.size()) * 2) return -1;

            if (sum1 == sum2) break;
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

    public Queue<Integer> initQueue(int[] queue) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < queue.length; i++) q.add(queue[i]);

        return q;
    }

    public long findSum(int[] queue) {
        int sum = 0;
        for (int i = 0; i < queue.length; i++) sum += queue[i];

        return sum;
    }
}