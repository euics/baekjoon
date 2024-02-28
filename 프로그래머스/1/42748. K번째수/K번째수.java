import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for(int d = 0; d < commands.length; d++) {
            int i = commands[d][0] - 1;
            int j = commands[d][1] - 1;
            int k = commands[d][2] - 1;

            List<Integer> list = new ArrayList<>();
            for(int start = i; start <= j; start++) list.add(array[start]);
            Collections.sort(list);

            answer.add(list.get(k));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}