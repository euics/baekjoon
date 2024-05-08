class Solution {
    public int solution(int k, int[][] dungeons) {
        dis = new int[dungeons.length];
        bool = new boolean[dungeons.length];
        permutation(0, k, dungeons);
        
        return max;
    }
    
    static int[] dis;
    static boolean[] bool;
    static int max = Integer.MIN_VALUE;
    
    public void permutation(int L, int k, int[][] dungeons) {
        if(L == dungeons.length) {
            max = Math.max(max, countPassDungeons(k, dungeons));
            
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!bool[i]) {
                bool[i] = true;
                dis[L] = i;
                permutation(L + 1, k, dungeons);
                bool[i] = false;
            }
        }        
    }
    
    public int countPassDungeons(int k, int[][] dungeons) {
        int tmp = k, count = 0;
        
        for(int index : dis) {
            if(tmp >= dungeons[index][0]) {
                tmp -= dungeons[index][1];
            } else {
                break;
            }
            
            count++;
        }
        
        return count;
    }
}