import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int answer = 0;
        int cameraPosition = Integer.MIN_VALUE;
        
        for(int[] route : routes){
            if(route[0] > cameraPosition){
                cameraPosition = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}