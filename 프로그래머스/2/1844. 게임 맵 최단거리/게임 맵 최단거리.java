import java.util.*;

class Solution {
    static int[][] dis;
    
    static boolean[][] bool;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        BFS(maps);
        
        return dis[n - 1][m - 1] + 1 == 1 ? -1 : dis[n - 1][m - 1] + 1;
    }
    
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};
    
    public void BFS(int maps[][]){
        int n = maps.length;
        int m = maps[0].length;
        bool = new boolean[n][m];
        dis = new int[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        bool[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = cur[0] + dix[d];
                int ny = cur[1] + diy[d];
                
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && maps[ny][nx] == 1){
                    if(!bool[ny][nx]){
                        bool[ny][nx] = true;
                        dis[ny][nx] = dis[cur[1]][cur[0]] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}