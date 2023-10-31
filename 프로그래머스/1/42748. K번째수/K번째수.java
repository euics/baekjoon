import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < commands.length; i++){
            
            int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tmp);
            
            answer.add(tmp[commands[i][2] - 1]);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}