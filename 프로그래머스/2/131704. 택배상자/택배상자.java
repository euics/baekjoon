import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> subContainer = new Stack<>();
        int cnt = 0, nextBox = 1;

        for(int target : order) {

            while(nextBox <= target) subContainer.add(nextBox++);

            if(subContainer.peek() == target) {
                subContainer.pop();
                cnt++;
            } else break;
        }

        return cnt;
    }
}