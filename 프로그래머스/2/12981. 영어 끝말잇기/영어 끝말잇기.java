import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> dic = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            if (i > 0 && fail(dic, words[i - 1], words[i])) {
                return new int[]{i % n + 1, i / n + 1};
            }

            dic.add(words[i]);
        }

        return new int[]{0, 0};
    }

    public boolean fail(Set<String> dic, String prev, String next) {
        if (dic.contains(next)) return true;
        if (prev.charAt(prev.length() - 1) != next.charAt(0)) return true;
        if (next.length() == 1) return true;

        return false;
    }
}