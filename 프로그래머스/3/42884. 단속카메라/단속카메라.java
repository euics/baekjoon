import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> pq = initQueue(routes);
        
        int camera = Integer.MIN_VALUE;
        int answer = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if(cur[0] > camera) {
                camera = cur[1];
                answer++;
            }
        }
        
        return answer;
    }
    
    public PriorityQueue<int[]> initQueue(int[][] routes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[] route : routes) pq.add(new int[]{route[0], route[1]});
        
        return pq;
    }
}

// -20 -15
// -18 -13
// -14 -5
// -5  -3