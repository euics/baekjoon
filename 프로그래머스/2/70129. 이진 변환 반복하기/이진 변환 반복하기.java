import java.util.*;

class Solution {
    public int[] solution(String s) {
        int loop = 0, deleted = 0;

        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '0') deleted++;

            s = s.replace("0", "");
            s = Integer.toString(s.length(), 2);

            loop++;
        }

        return new int[]{loop, deleted};
    }
}