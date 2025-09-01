import java.util.*;

class Solution {
    public int solution(int[] order) {
        int ans = 0;

        Queue<Integer> belt = new LinkedList<>();
        for (int i = 1; i <= order.length; i++) belt.add(i);
        Stack<Integer> sub = new Stack<>();

        for (int i = 0; i < order.length; i++) {
            boolean bool = false;

            if (!sub.isEmpty() && sub.peek() == order[i]) {
                sub.pop();
                ans++;
                bool = true;

                continue;
            }

            while (!belt.isEmpty()) {
                if (belt.peek() == order[i]) {
                    belt.poll();
                    ans++;
                    bool = true;

                    break;
                } else {
                    sub.push(belt.poll());
                }
            }

            if (!bool) break;
        }

        return ans;
    }
}