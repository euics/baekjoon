import java.util.*;

class Solution {
    static int idx = 27;
    static Map<String, Integer> dic = new HashMap<>();

    public int[] solution(String msg) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 26; i++) dic.put(String.valueOf((char) ((int) 'A' + i - 1)), i);

        int p = 0;
        while (p < msg.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(p));

            while (p + 1 < msg.length() && dic.containsKey(sb.toString() + msg.charAt(p + 1))) {
                sb.append(msg.charAt(p + 1));
                p++;
            }

            ans.add(dic.get(sb.toString()));

            if (p + 1 < msg.length()) {
                sb.append(msg.charAt(p + 1));
                dic.put(sb.toString(), idx++);
            }

            p++;
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}