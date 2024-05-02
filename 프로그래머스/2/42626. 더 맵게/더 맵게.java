import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = initPQ(scoville);
        
        int answer = 0;
        while(!pq.isEmpty() && pq.size() >= 2 && pq.peek() < K) {
            pq.add(pq.poll() + (pq.poll() * 2));
            answer++;
        }
        
        return pq.peek() < K ? -1 : answer;
    }
    
    public PriorityQueue<Integer> initPQ(int[] scoville) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) pq.add(scoville[i]);
        
        return pq;
    }
}