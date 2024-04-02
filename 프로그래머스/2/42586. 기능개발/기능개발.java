import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> remainDays = new LinkedList<>();
        int n = progresses.length;

        for(int i = 0; i < n; i++) {
            int days = 0;

            if((100 - progresses[i]) % speeds[i] != 0) days = ((100 - progresses[i]) / speeds[i]) + 1;
            else days = (100 - progresses[i]) / speeds[i];

            remainDays.add(days);
        }

        List<Integer> answer = new ArrayList<>();
        while(!remainDays.isEmpty()) {
            int prevDays = remainDays.poll();
            int cnt = 1;
            
            while(!remainDays.isEmpty() && prevDays >= remainDays.peek()) {
                remainDays.poll();
                cnt++;
            }
            
            answer.add(cnt);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}