import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++)
            pq.add(scoville[i]);
        
        int cnt = 0;
        while(!pq.isEmpty()){
            int firstScoville = pq.poll();
            
            if(firstScoville >= K)
                return cnt;
            
            if(pq.isEmpty())
                return -1;
            
            int secondScoville = pq.poll();
            
            pq.add(calculateScoville(firstScoville, secondScoville));
            cnt++;
        }
        
        return -1;
    }
    
    public int calculateScoville(int firstScoville, int secondScoville){
        return firstScoville + (secondScoville * 2);
    }
}