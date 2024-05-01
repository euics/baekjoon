import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Progress> pq = new PriorityQueue<>();
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            pq.add(new Progress(i, priorities[i]));
            q.add(new int[]{i, priorities[i]});
        }
        int answer = 1;
        while(!pq.isEmpty()) {
            Progress cur = pq.poll();
            
            while(!q.isEmpty() && q.peek()[1] != cur.priority) q.add(q.poll());
            
            if(q.poll()[0] == location) return answer;
            answer++;
        }
        
        return -1;
    }
}

class Progress implements Comparable<Progress> {
    int id, priority;
    public Progress(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
    
    @Override
    public int compareTo(Progress o) {
        return o.priority - this.priority;
    }
}