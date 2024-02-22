import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.add(s);

        while (pq.peek() < K) {
            if(pq.size() == 1 && pq.peek() < K) return -1;

            int mix = mix(pq.poll(), pq.poll());
            pq.add(mix);
            answer++;
        }

        return answer;
    }
    
    private int mix(int a, int b){
        return a + (b * 2);
    }
}