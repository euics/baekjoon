import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) pq.add(work);

        while (!pq.isEmpty()) {
            if(n == 0) break;

            int cur = pq.poll() - 1;
            if(cur != 0) pq.add(cur);

            n--;
        }

        long answer = 0;
        for(int val : pq) answer += Math.pow(val, 2);
        return answer;
    }
}