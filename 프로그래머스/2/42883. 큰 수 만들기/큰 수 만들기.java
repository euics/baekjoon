import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);

            while(!stack.isEmpty() && stack.peek() < cur && k > 0) {
                stack.pop();
                k--;
            }
            
            stack.push(cur);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0, stack.pop());

        return sb.toString();
    }
}