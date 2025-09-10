import java.util.*;

class Solution {
    static int ans = 0;

    public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        while (idx < dartResult.length()) {
            StringBuilder sb = new StringBuilder();
            while (Character.isDigit(dartResult.charAt(idx))) sb.append(dartResult.charAt(idx++));
            int score = Integer.parseInt(sb.toString());

            char bonus = dartResult.charAt(idx++);
            if (bonus == 'D') score = (int) Math.pow(score, 2);
            if (bonus == 'T') score = (int) Math.pow(score, 3);
            stack.push(score);

            char option = 'X';
            if (idx < dartResult.length()) {
                if (dartResult.charAt(idx) == '#' || dartResult.charAt(idx) == '*') {
                    option = dartResult.charAt(idx++);

                    if (stack.size() == 1) {
                        int cur = stack.pop();

                        if (option == '*') {
                            stack.push(cur * 2);
                        } else {
                            stack.push(cur * (-1));
                        }
                    } else {
                        int cur = stack.pop();
                        int prev = stack.pop();

                        if (option == '*') {
                            stack.push(prev * 2);
                            stack.push(cur * 2);
                        } else {
                            stack.push(prev);
                            stack.push(cur * (-1));
                        }
                    }
                }
            }
        }

        while (!stack.isEmpty()) ans += stack.pop();

        return ans;
    }
}