import java.util.*;

class Solution {
    public int solution(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (accept(s)) ans++;
            s = s.substring(1) + s.charAt(0);
        }

        return ans;
    }

    public boolean accept(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                if (ch == ')') if (stack.peek() != '(') return false;
                if (ch == ']') if (stack.peek() != '[') return false;
                if (ch == '}') if (stack.peek() != '{') return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}