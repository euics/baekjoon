import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> subContainer = new Stack<>();
        int answer = 0, nextBox = 1;

        for(int target : order) {

            while (nextBox <= target) subContainer.push(nextBox++);

            if(subContainer.peek() == target) {
                answer++;
                subContainer.pop();
            } else break;
        }
        
        return answer;
    }
}