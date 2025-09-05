import java.util.*;

class Solution {
    static StringBuilder ans = new StringBuilder();
    static int[][] phone = new int[][]{
            {1, 3},
            {0, 0}, {1, 0}, {2, 0},
            {0, 1}, {1, 1}, {2, 1},
            {0, 2}, {1, 2}, {2, 2},
            {0, 3}, {2, 3}
    };

    public String solution(int[] numbers, String hand) {
        int[] left = new int[2], right = new int[2];
        left = phone[10];
        right = phone[11];

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if (num == 1 || num == 4 || num == 7) {
                left = phone[num];
                ans.append("L");
            } else if (num == 3 || num == 6 || num == 9) {
                right = phone[num];
                ans.append("R");
            } else {
                int leftLength = Math.abs(phone[num][0] - left[0]) + Math.abs(phone[num][1] - left[1]);
                int rightLength = Math.abs(phone[num][0] - right[0]) + Math.abs(phone[num][1] - right[1]);

                if (leftLength < rightLength) {
                    left = phone[num];
                    ans.append("L");
                } else if (leftLength > rightLength) {
                    right = phone[num];
                    ans.append("R");
                } else {
                    if (hand.equals("left")) {
                        left = phone[num];
                        ans.append("L");
                    } else {
                        right = phone[num];
                        ans.append("R");
                    }
                }
            }
        }

        return ans.toString();
    }
}