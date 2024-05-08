class Solution {
    public int solution(int k, int[][] dungeons) {
        indexes = new int[dungeons.length];
        bool = new boolean[dungeons.length];
        max = Integer.MIN_VALUE;
        
        permutation(0, k, dungeons);
        
        return max;
    }
    
    static int[] indexes;
    static boolean[] bool;
    static int max;
    
    public void permutation(int L, int k, int[][] dungeons) {
        if(L == dungeons.length) {
            max = Math.max(max, countPass(k, dungeons));
            
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!bool[i]) {
                bool[i] = true;
                indexes[L] = i;
                permutation(L + 1, k, dungeons);
                bool[i] = false;
            }
        }
    }
    
    public int countPass(int k, int[][] dungeons) {
        int tmp = k, cnt = 0;
        
        for(int index : indexes) {
            if(tmp >= dungeons[index][0]) {
                tmp -= dungeons[index][1];
            } else {
                break;
            }
            
            cnt++;
        }
        
        return cnt;
    }
}