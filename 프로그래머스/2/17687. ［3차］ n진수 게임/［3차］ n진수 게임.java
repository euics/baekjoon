import java.util.*;

class Solution {
    static StringBuilder ans = new StringBuilder();

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int end = (t + 1) * m;
        int number = 1;
        sb.append(0);
        while (sb.length() < end) sb.append(convert(number++, n));

        int start = p - 1;
        while (ans.length() < t) {
            ans.append(sb.toString().charAt(start));
            start += m;
        }

        return ans.toString();
    }

    public String convert(int number, int n) {
        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            int remain = number % n;

            if (remain >= 10) {
                remain = (int) 'A' + remain % 10;
                sb.insert(0, (char) remain);
            } else {
                sb.insert(0, remain);
            }

            number /= n;
        }

        return sb.toString();
    }
}