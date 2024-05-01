import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] bool = new boolean[y + 1];
        q.add(x);
        int L = 0;

        while(!q.isEmpty()) {
            int length = q.size();

            for(int i = 0; i < length; i++) {
                int cur = q.poll();
                if(cur == y) return L;

                int[] next = new int[]{cur + n, cur * 2, cur * 3};
                for(int d = 0; d < 3; d++) {
                    if(next[d] > y || bool[next[d]]) continue;
                    if(next[d] <= y && !bool[next[d]]) {
                        q.add(next[d]);
                        bool[next[d]] = true;
                    }
                }
            }

            L++;
        }

        return -1;
    }
}

// +n *2 *3