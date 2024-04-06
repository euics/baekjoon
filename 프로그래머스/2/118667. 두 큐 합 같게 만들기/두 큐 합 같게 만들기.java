import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> a = initQueue(queue1);
        Queue<Integer> b = initQueue(queue2);

        long sum1 = sumQueue(a);
        long sum2 = sumQueue(b);

        if((sum1 + sum2) % 2 != 0) return -1;

        while (true) {
            if(answer > (a.size() + b.size()) * 2) return -1;

            if(sum1 == sum2) break;
            else if(sum1 < sum2) {
                sum1 += b.peek();
                sum2 -= b.peek();
                a.add(b.poll());
            } else {
                sum1 -= a.peek();
                sum2 += a.peek();
                b.add(a.poll());
            }

            answer++;
        }

        return answer;
    }

    public Queue<Integer> initQueue(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        for(int num : arr) q.add(num);

        return q;
    }

    public long sumQueue(Queue<Integer> q) {
        int sum = 0;
        for(int value : q) sum += value;

        return sum;
    }
}