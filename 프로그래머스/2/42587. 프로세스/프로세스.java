import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++)
            q.add(new int[]{i, priorities[i]});
        
        ArrayList<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            boolean bool = false;
            for(int i = 0; i < q.size(); i++){
                int[] checkPriority = q.poll();
                
                if(checkPriority[1] > cur[1])
                    bool = true;
                
                q.add(checkPriority);
            }
            
            if(bool)
                q.add(cur);
            else
                answer.add(cur[0]);
        }
        
        return answer.indexOf(location) + 1;
    }
}