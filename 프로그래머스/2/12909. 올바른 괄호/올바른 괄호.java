import java.util.*;

class Solution {
    boolean solution(String str) {
        Stack<Character> s = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') s.push(ch);
            else {
                if (s.isEmpty()) return false;
                s.pop();
            }
        }

        return s.isEmpty();
    }
}