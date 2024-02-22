import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> programs = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < jobs.length; i++) programs.add(new int[]{jobs[i][0], jobs[i][1]});

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int finishTime = 0, totalTime = 0;
        while(!programs.isEmpty() || !pq.isEmpty()) {
            if(pq.isEmpty()) finishTime = Math.max(finishTime, programs.peek()[0]);

            while(!programs.isEmpty() && programs.peek()[0] <= finishTime) {
                int[] possibleProgram = programs.poll();
                pq.add(new int[]{possibleProgram[0], possibleProgram[1]});
            }

            int[] cur = pq.poll();
            finishTime += cur[1];
            totalTime += finishTime - cur[0];
        }

        return totalTime / jobs.length;
    }
}