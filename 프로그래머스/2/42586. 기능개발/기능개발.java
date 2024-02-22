import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) day += 1;
            days.add(day);
        }

        List<Integer> answer = new ArrayList<>();
        while (!days.isEmpty()) {
            int cnt = 1;
            int cur = days.poll();

            while (!days.isEmpty() && days.peek() <= cur) {
                days.poll();
                cnt++;
            }

            answer.add(cnt);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}