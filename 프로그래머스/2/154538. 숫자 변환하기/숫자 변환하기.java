import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        else return BFS(x, y, n);
    }

    private int BFS(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] bool = new boolean[y + 1];
        q.add(x);
        int L = 1;

        while (!q.isEmpty()) {
            int length = q.size();

            for (int i = 0; i < length; i++) {
                int cur = q.poll();
                int[] next = new int[]{cur * 2, cur * 3, cur + n};

                for(int d = 0; d < 3; d++) {
                    if(next[d] > y) continue;
                    if(next[d] == y) return L;

                    if(!bool[next[d]]) {
                        bool[next[d]] = true;
                        q.add(next[d]);
                    }

                }
            }

            L++;
        }

        return -1;
    }
}