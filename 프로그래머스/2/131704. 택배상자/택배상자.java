import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0, nextBox = 1;
        
        for(int target : order) {
            
            while (nextBox <= target) stack.push(nextBox++);
            
            if(stack.peek() == target) {
                stack.pop();
                answer++;
            } else break;
        }
        
        return answer;
    }
}