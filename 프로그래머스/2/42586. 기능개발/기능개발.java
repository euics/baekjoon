import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            int leftProgress = 100 - progresses[i];
            
            if(leftProgress % speeds[i] == 0)
                days.add(leftProgress / speeds[i]);
            else
                days.add(leftProgress / speeds[i] + 1);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        while(!days.isEmpty()){
            int cnt = 1;
            int cur = days.poll();
            
            while(!days.isEmpty() && days.peek() <= cur){
                days.poll();
                cnt++;
            }
            
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}