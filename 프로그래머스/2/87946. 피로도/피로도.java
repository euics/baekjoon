import java.util.*;

class Solution {
    static int[] pm;
    static boolean[] bool;
    
    public int solution(int k, int[][] dungeons) {
        Arrays.sort(dungeons, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        pm = new int[dungeons.length];
        bool = new boolean[dungeons.length];
        permutation(0, dungeons, k);
        
        return max;
    }
    
    static int max = Integer.MIN_VALUE;
    
    public void permutation(int L, int[][] dungeons, int k){
        if(L == dungeons.length){
            max = Math.max(max, cntMove(dungeons, k));
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            if(!bool[i]){
                bool[i] = true;
                pm[L] = i;
                permutation(L + 1, dungeons, k);
                bool[i] = false;
            }
        }
    }
    
    public int cntMove(int[][] dungeons, int k){
        int tmp = k, cnt = 0;
        for(int i = 0; i < pm.length; i++){
            int index = pm[i];
            
            int minTired = dungeons[index][0];
            int useTired = dungeons[index][1];
            
            if(tmp >= minTired){
                tmp -= useTired;
                cnt++;
            } else break;
        }
        
        return cnt;
    }
}