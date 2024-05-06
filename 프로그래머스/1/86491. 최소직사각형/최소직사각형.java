class Solution {
    public int solution(int[][] sizes) {
        int rowSize = Integer.MIN_VALUE, colSize = Integer.MIN_VALUE;
        
        for(int[] size : sizes) {
            int row = Math.max(size[0], size[1]);
            int col = Math.min(size[0], size[1]);
            
            rowSize = Math.max(row, rowSize);
            colSize = Math.max(col, colSize);
        }
        
        return rowSize * colSize;
    }
}