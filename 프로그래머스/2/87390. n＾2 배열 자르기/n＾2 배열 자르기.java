import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();
        
        for(long i = left; i <= right; i++){
            int row = (int)(i / n); // 행위치
            int col = (int)(i % n); // 열위치
            
            answer.add(Math.max(row, col) + 1);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}