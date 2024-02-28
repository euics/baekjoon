import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];

        int i = 0;
        for(int answer : answers) {
            if(answer == first[i % 5]) scores[0]++;
            if(answer == second[i % 8]) scores[1]++;
            if(answer == third[i % 10]) scores[2]++;
            
            i++;
        }

        int max = Integer.MIN_VALUE;
        for(int score : scores) max = Math.max(max, score);

        List<Integer> answer = new ArrayList<>();
        for(int d = 0; d < 3; d++) {
            if(scores[d] == max) answer.add(d + 1);
        }
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(num -> num).toArray();
    }
}