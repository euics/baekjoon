import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int[] ranks = new int[priorities.length];
        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Process(i, priorities[i]));
            pq.add(priorities[i]);
        }

        int rank = 1;
        while (!q.isEmpty()) {
            Process cur = q.poll();
            if (pq.peek() == cur.priority) {
                ranks[cur.id] = rank++;
                pq.poll();
            } else q.add(cur);
        }

        return ranks[location];
    }
}

class Process {
    int id, priority;

    public Process(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}