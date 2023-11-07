import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < number.length(); i++){
            char ch = number.charAt(i);
            
            while(!stack.isEmpty() && stack.peek() < ch && k > 0){
                stack.pop();
                k--;
            }
            
            stack.push(ch);
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
    }
}