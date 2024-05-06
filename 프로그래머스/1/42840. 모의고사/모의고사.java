import java.util.*;

class Solution {
    static int[] first = new int[]{1, 2, 3, 4, 5}; // 5개
    static int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5}; // 8개
    static int[] thrid = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개
    
    public int[] solution(int[] answers) {
        int[] peoples = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == first[i % 5]) peoples[0]++;
            if(answers[i] == second[i % 8]) peoples[1]++;
            if(answers[i] == thrid[i % 10]) peoples[2]++;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) max = Math.max(max, peoples[i]);
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(max == peoples[i]) answer.add(i + 1);
        }
        Collections.sort(answer);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}