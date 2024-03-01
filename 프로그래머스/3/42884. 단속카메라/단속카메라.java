import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int camera = Integer.MIN_VALUE, answer = 0;

        for(int[] route : routes) {
            if(camera < route[0]) {
                answer++;
                camera = route[1];
                System.out.println(camera);
            }
        }

        return answer;
    }
}