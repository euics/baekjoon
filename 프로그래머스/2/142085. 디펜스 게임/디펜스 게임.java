import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int rounds = 0;
        int remainingSoldiers = n;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);

            if (remainingSoldiers >= enemy[i]) {
                remainingSoldiers -= enemy[i];
            } else {
                if (k > 0) {
                    k--;
                    remainingSoldiers += pq.poll();  // 가장 큰 값을 무적권으로 처리
                    remainingSoldiers -= enemy[i];
                } else {
                    break;
                }
            }

            rounds++;
        }

        return rounds;
    }
}
