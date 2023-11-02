import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            list.add(new int[]{max, min});
        }
        
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++){
            maxRow = Math.max(maxRow, list.get(i)[0]);
            maxCol = Math.max(maxCol, list.get(i)[1]);
        }
        
        return maxRow * maxCol;
    }
}