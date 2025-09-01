import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        boolean[] bool = new boolean[y + 1];
        bool[x] = true;

        int L = 0;
        while (!q.isEmpty()) {
            int length = q.size();

            for (int i = 0; i < length; i++) {
                int cur = q.poll();
                if (cur == y) return L;

                int[] next = {cur + n, cur * 2, cur * 3};
                for (int d = 0; d < 3; d++) {
                    if (next[d] <= y) {
                        if (!bool[next[d]]) {
                            bool[next[d]] = true;
                            q.add(next[d]);
                        }
                    }
                }
            }

            L++;
        }

        return -1;
    }
}