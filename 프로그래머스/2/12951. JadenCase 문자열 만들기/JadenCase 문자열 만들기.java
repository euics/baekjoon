import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                sb.append(" ");
                newWord = true;
            } else if (newWord) {
                sb.append(Character.toUpperCase(ch));
                newWord = false;
            } else {
                sb.append(Character.toLowerCase(ch));
            }
        }

        return sb.toString();
    }
}