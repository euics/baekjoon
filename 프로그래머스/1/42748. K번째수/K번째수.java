import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for(int[] command : commands) {
            
            int[] copy = new int[command[1] - command[0] + 1];            
            for(int i = command[0] - 1, index = 0; i < command[1]; i++) {
                copy[index++] = array[i];
            }
            Arrays.sort(copy);
            
            answer.add(copy[command[2] - 1]);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}