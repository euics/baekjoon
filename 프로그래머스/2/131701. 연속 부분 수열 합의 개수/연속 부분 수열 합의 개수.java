import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> answer = new HashSet<>();
        
        for(int start = 0; start < n; start++){
            int sum = 0;
            for(int length = 1; length <= n; length++){
                sum += elements[(start + length - 1) % n];
                answer.add(sum);
            }
        }
        
        return answer.size();
    }
}