import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() != ch) stack.push(ch);
                else while (!stack.isEmpty() && stack.peek() == ch) stack.pop();
            } else stack.push(ch);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}