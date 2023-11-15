import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i = 0; i < n; i++) programs.add(new int[]{jobs[i][0], jobs[i][1]});
        Collections.sort(programs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int finishTime = 0, totalTime = 0;
        while(!pq.isEmpty() || !programs.isEmpty()){
            if(pq.isEmpty()) finishTime = Math.max(finishTime, programs.peek()[0]);
            
            while(!programs.isEmpty() && programs.peek()[0] <= finishTime){
                int[] prevProgram = programs.pollFirst();
                pq.add(new int[]{prevProgram[0], prevProgram[1]});
            }
            
            int[] cur = pq.poll();
            finishTime += cur[1];
            totalTime += finishTime - cur[0];
        }
        
        return totalTime / n;
    }
}