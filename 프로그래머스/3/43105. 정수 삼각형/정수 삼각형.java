class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        for(int row = n - 2; row >= 0; row--) {
            for(int col = 0; col < triangle[row].length; col++) {
                triangle[row][col] = Math.max(triangle[row + 1][col] + triangle[row][col], triangle[row + 1][col + 1] + triangle[row][col]);
            }
        }
        
        return triangle[0][0];
    }
}