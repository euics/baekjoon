import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) days[i] = (100 - progresses[i]) / speeds[i];
            else days[i] = (100 - progresses[i]) / speeds[i] + 1;
        }

        for (int i = 1; i < days.length; i++) if (days[i - 1] >= days[i]) days[i] = days[i - 1];
        for (int day : days) System.out.printf("%d ", day);

        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        while (end < days.length) {
            int cnt = 0;
            while (end < days.length && days[start] == days[end]) {
                end++;
                cnt++;
            }

            ans.add(cnt);
            start = end;
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}