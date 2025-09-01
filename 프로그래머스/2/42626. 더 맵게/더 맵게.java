import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : scoville) pq.add(x);

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur >= K) return ans;
            if (pq.isEmpty()) return -1;

            int next = pq.poll();
            pq.add(cur + (next * 2));

            ans++;
        }

        return ans;
    }
}