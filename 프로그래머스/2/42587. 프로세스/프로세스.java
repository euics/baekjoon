import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) pq.add(priority);

        Queue<int[]> process = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) process.add(new int[]{i, priorities[i]});

        int seq = 1;
        while (!pq.isEmpty()) {
            int priority = pq.poll();

            int size = process.size();
            for (int i = 0; i < size; i++) {
                int[] cur = process.poll();

                if (cur[1] == priority) {
                    if (cur[0] == location) {
                        return seq;
                    }
                    
                    break;
                } else {
                    process.add(cur);
                }
            }

            seq++;
        }

        return -1;
    }
}