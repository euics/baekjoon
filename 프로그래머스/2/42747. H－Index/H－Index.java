import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        
        int h = tmp[0], max = Integer.MIN_VALUE;
        while(h >= 0) {
            int cnt = 0;
            
            for(int i = 0; i < n; i++) {
                if(citations[i] >= h) {
                    cnt++;
                }
            }
            
            if(cnt >= h && max < h) {
                max = h;
                break;
            }
            
            h--;
        }
        
        return h;
    }
}