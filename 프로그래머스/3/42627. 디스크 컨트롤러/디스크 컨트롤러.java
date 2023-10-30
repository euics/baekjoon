import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i = 0; i < n; i++)
            programs.add(new int[]{jobs[i][0], jobs[i][1]});
        Collections.sort(programs, (a, b) -> a[0] - b[0]);
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int totalTime = 0, finishTime = 0;
        while(!programs.isEmpty() || !pq.isEmpty()){
            if(pq.isEmpty())
                finishTime = Math.max(finishTime, programs.peek()[0]);
            
            while(!programs.isEmpty() && programs.peek()[0] <= finishTime){
                int[] cur = programs.pollFirst();
                pq.add(new int[]{cur[0], cur[1]});
            }
            
            int[] next = pq.poll();
            finishTime += next[1];
            totalTime += finishTime - next[0];
        }
        
        return totalTime / n;
    }
}