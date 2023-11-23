import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return binarySearch(distance, rocks, n);
    }
    
    public int binarySearch(int distance, int[] rocks, int n){
        int left = 0;
        int right = distance;
        int answer = 0;
        
        while(left <= right){
            int mid = (left + right) / 2;
            int removedRocks = 0;
            int prev = 0;
            
            for(int rock : rocks){
                if(rock - prev < mid) removedRocks++;
                else prev = rock;
            }
            
            if(distance - prev < mid) removedRocks++;
            
            if(removedRocks <= n){
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else right = mid - 1;
        }
        
        return answer;
    }
}