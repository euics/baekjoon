import java.util.*;

class Solution {
    static int[] dix = {0, 1, -1};
    static int[] diy = {1, 0, -1};
    
    public int[] solution(int n) {
        int[][] triangle = new int[n][];
        for(int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }
        
        int max = (n * (n + 1)) / 2, num = 1;
        int x = 0, y = 0, d = 0;
        
        while(num <= max) {
            triangle[y][x] = num++;
            
            int nx = x + dix[d];
            int ny = y + diy[d];
            
            if(nx < 0 || ny < 0 || ny >= triangle.length || nx >= triangle[ny].length || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dix[d];
                ny = y + diy[d];
            }
            
            x = nx;
            y = ny;
        }
        
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                answer.add(triangle[i][j]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}