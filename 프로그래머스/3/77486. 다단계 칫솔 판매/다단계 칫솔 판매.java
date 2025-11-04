import java.util.*;

class Solution {
    static int[] ans;
    static Map<String, String> graph = new HashMap<>();
    static Map<String, Integer> profit = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < referral.length; i++) graph.put(enroll[i], referral[i]);
        for (int i = 0; i < amount.length; i++) amount[i] *= 100;

        for (int i = 0; i < seller.length; i++) {
            profit.put(seller[i], profit.getOrDefault(seller[i], 0) + amount[i] - amount[i] / 10);
            String parent = seller[i];
            int left = amount[i] / 10;

            while (!parent.equals("-")) {
                parent = graph.get(parent);
                if (parent.equals("-")) profit.put(parent, profit.getOrDefault(parent, 0) + left);
                else profit.put(parent, profit.getOrDefault(parent, 0) + left - left / 10);
                left /= 10;

                if (left < 1) break;
            }
        }

        ans = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) ans[i] = profit.get(enroll[i]) == null ? 0 : profit.get(enroll[i]);

        return ans;
    }
}