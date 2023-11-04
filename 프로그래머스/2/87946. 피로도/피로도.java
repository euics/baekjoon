import java.util.*;

class Solution {
    
    static int max = Integer.MIN_VALUE;
    static boolean[] bool;
    
    public int solution(int k, int[][] dungeons) {
        bool = new boolean[dungeons.length];
        DFS(dungeons, k, 0);
        
        return max;
    }
    
    public void DFS(int[][] dungeons, int curK, int cnt){
        for(int i = 0; i < dungeons.length; i++){
            if(!bool[i] && dungeons[i][0] <= curK){
                bool[i] = true;
                DFS(dungeons, curK - dungeons[i][1], cnt + 1);
                bool[i] = false;
            }
        }
        
        max = Math.max(max, cnt);
    }
}