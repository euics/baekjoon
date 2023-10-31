import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < commands.length; i++){
            
            List<Integer> list = new ArrayList<>();
            
            for(int start = commands[i][0] - 1; start < commands[i][1]; start++)
                list.add(array[start]);
            
            Collections.sort(list);
            
            answer.add(list.get(commands[i][2] - 1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}