import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int num : arr) {
            if(!stack.isEmpty() && stack.peek() == num) continue;

            stack.push(num);
        }

        int[] answer = new int[stack.size()];
        int index = answer.length - 1;
        while(!stack.isEmpty()) answer[index--] = stack.pop();
        
        return answer;
    }
}