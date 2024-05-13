import java.util.*;

class Solution {
    static int[] unf, groupSize;
    
    public int solution(int n, int[][] costs) {
        init(n);
        PriorityQueue<int[]> pq = initQueue(costs);
        
        int answer = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int fv1 = find(cur[0]);
            int fv2 = find(cur[1]);
            
            if(fv1 != fv2) {
                union(cur[0], cur[1]);
                answer += cur[2];
            }
        }
        
        return answer;
    }
    
    public void init(int n) {
        unf = new int[n];
        groupSize = new int[n];
        for(int i = 0; i < n; i++) {
            unf[i] = i;
            groupSize[i] = 1;
        }
    }
    
    public PriorityQueue<int[]> initQueue(int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);        
        
        for(int[] cost : costs) {
            pq.add(new int[]{cost[0], cost[1], cost[2]});
        }
        
        return pq;
    }
    
    public int find(int v) {
        if(v == unf[v]) return unf[v];
        else return unf[v] = find(unf[v]);
    }
    
    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        
        if(fa != fb) {
            unf[fa] = fb;
            groupSize[fb] += groupSize[fa];
        }
    }
}