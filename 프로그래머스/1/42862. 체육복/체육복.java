import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] info = new int[n];
        Arrays.fill(info, 1);
        for(int i = 0; i < reserve.length; i++) info[reserve[i] - 1]++;
        for(int i = 0; i < lost.length; i++) info[lost[i] - 1]--;
        
        for(int i = 0; i < n; i++) {
            if(i - 1 >= 0 && info[i] > 1 && info[i - 1] == 0) {
                info[i]--;
                info[i - 1]++;
            }
            if(i + 1 < n && info[i] > 1 && info[i + 1] == 0) {
                info[i]--;
                info[i + 1]++;
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(info[i] >= 1) cnt++;
        }
        
        return cnt;
    }
}