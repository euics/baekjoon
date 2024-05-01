import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dueDates = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            int dueDate = 0;
            if((100 - progresses[i]) % speeds[i] == 0) {
                dueDate = (100 - progresses[i]) / speeds[i];
            } else {
                dueDate = (100 - progresses[i]) / speeds[i] + 1;
            }
            dueDates[i] = dueDate;
        }
        
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < dueDates.length; i++) {
            int dueDate = dueDates[i];
            int cnt = 0;
            while(i < dueDates.length && dueDate >= dueDates[i]) {
                cnt++;
                i++;
            }
            answer.add(cnt);
            i--;
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}