import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        
        int n = tmp.length;
        
        // 6 5 3 1 0
        
        int h = tmp[0], max = 0;
        
        while(h >= 0) {

            int cnt = 0;
            
            for(int i = 0; i < n; i++){
                if(tmp[i] >= h)
                    cnt++;
            }
            
            if(cnt >= h){
                max = Math.max(max, h);
                break;
            }
            
            h--;
            
        }
        
        return max;
    }
}