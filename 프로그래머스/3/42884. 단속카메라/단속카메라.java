import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int answer = 0;
        for(int i = 0, finishTime = Integer.MIN_VALUE; i < routes.length; i++){
            if(routes[i][0] > finishTime) {
                finishTime = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}