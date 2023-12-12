import java.util.*;

class Solution {
    static int[] pm;
    static boolean[] bool;
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        pm = new int[n];
        bool = new boolean[n];

        permutation(0, n, k, dungeons);

        return max;
    }

    static int max = Integer.MIN_VALUE;

    public void permutation(int L, int n, int k, int[][] dungeons){
        if(L == n){
            findMax(k, dungeons);

            return;
        }

        for(int i = 0; i < n; i++){
            if(!bool[i]){
                pm[L] = i;
                bool[i] = true;
                permutation(L + 1, n, k, dungeons);
                bool[i] = false;
            }
        }
    }

    public void findMax(int k, int[][] dungeons){
        int cnt = 0;
        int tmp = k;

        for(int index : pm) {
            if(tmp >= dungeons[index][0]){
                tmp -= dungeons[index][1];
                cnt++;
            } else {
                break;
            }
        }

        max = Math.max(max, cnt);
    }
}