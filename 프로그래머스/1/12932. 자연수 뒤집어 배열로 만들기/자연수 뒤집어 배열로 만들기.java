import java.util.*;

class Solution {
    static List<Integer> answer = new ArrayList<>();
    
    public int[] solution(long n) {
        while(n > 0) {
            long tmp = n % 10;
            n /= 10;
            
            answer.add((int)tmp);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}