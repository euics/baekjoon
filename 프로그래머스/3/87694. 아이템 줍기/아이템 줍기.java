import java.util.*;

class Solution {
    int[] dix = {0, 0, -1, 1};
    int[] diy = {-1, 1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] elem : rectangle){
            elem[0] *= 2;
            elem[1] *= 2;
            elem[2] *= 2;
            elem[3] *= 2;
        }
        
        int[][] grid = extractPerimeter(rectangle);
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX * 2, characterY * 2});
        boolean[][] bool = new boolean[101][101];
        bool[characterY * 2][characterX * 2] = true;
        int L = 0;
        
        while(!q.isEmpty()){
            int length = q.size();
            
            for(int i = 0; i < length; i++){
                int[] cur = q.poll();
                
                if(cur[0] == itemX * 2 && cur[1] == itemY * 2){
                    return L / 2;
                }
                
                for(int d = 0; d < 4; d++){
                    int nx = cur[0] + dix[d];
                    int ny = cur[1] + diy[d];
                    
                    if(nx >= 0 && ny >= 0 && nx < 101 && ny < 101 && grid[ny][nx] == 1){
                        if(!bool[ny][nx]){
                            bool[ny][nx] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            
            L++;
        }
        
        return -1;
    }
    
    public int[][] extractPerimeter(int[][] rectangles){
        int[][] grid = new int[101][101];

        for (int[] rect : rectangles) {
            for (int x = rect[0]; x <= rect[2]; x++) {
                grid[rect[1]][x] = 1;
                grid[rect[3]][x] = 1;
            }
            for (int y = rect[1]; y <= rect[3]; y++) {
                grid[y][rect[0]] = 1;
                grid[y][rect[2]] = 1;
            }
        }
        
        for(int[] rect : rectangles){
            for(int y = rect[1] + 1; y < rect[3]; y++){
                for(int x = rect[0] + 1; x < rect[2]; x++){
                    grid[y][x] = 0;
                }
            }
        }

        return grid;
    }
}