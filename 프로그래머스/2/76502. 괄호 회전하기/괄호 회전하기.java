import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> dq = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            dq.addLast(s.charAt(i));
        }
        
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            
            if(checkString(dq)){
                answer++;
            }
            
            changeDeque(dq);
        }
        
        return answer;
    }
    
    public void changeDeque(Deque<Character> dq){
        dq.addLast(dq.pollFirst());
    }
    
    public boolean checkString(Deque<Character> dq){
        Iterator<Character> iter = dq.iterator();
        Stack<Character> stack = new Stack<>();
        
        while(iter.hasNext()){
            char cur = iter.next();
            
            if(cur == '(' || cur == '[' || cur == '{'){
                stack.push(cur);
            } else{
                
                if(stack.isEmpty()) return false;
                
                char top = stack.peek();
                if((top == '(' && cur == ')') || (top == '[' && cur == ']') || (top == '{' && cur == '}')){
                    stack.pop();
                } else{
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}