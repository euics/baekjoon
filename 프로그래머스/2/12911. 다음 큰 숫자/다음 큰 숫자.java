import java.util.*;

class Solution {
    public int solution(int n) {
        String str = Integer.toString(n, 2);
        int length = 0;
        for (char ch : str.toCharArray()) if (ch == '1') length++;

        for (int num = n + 1; ; num++) {
            String convert = Integer.toString(num, 2);

            int cnt = 0;
            for (char ch : convert.toCharArray()) if (ch == '1') cnt++;
            if (cnt == length) return num;
        }
    }
}