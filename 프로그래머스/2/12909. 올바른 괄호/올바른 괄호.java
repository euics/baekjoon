import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(') stack.push('(');
            else {
                if(stack.isEmpty()) return false;
                
                stack.pop();
            }
        }
        
        return stack.size() != 0 ? false : true;
    }
}