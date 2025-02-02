import java.util.*;

class Solution {
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};
    
    public int solution(String dirs) {
        int x = 0, y = 0, d = 0;
        Set<String> set = new HashSet<>();
        
        for(char dir : dirs.toCharArray()) {
            int nx = x;
            int ny = y;
            
            switch(dir) {
                case 'U':
                    d = 0;
                    ny -= 1;
                    
                    break;
                case 'D':
                    d = 1;
                    ny += 1;
                    
                    break;
                case 'R':
                    d = 3;
                    nx += 1;
                    
                    break;
                case 'L':
                    d = 2;
                    nx -= 1;
                    
                    break;
            }
            
            if(nx < -5 || ny < -5 || nx > 5 || ny > 5) {
                continue;
            }
            
            StringBuilder sb = new StringBuilder();
            set.add(sb.append(x).append(y).append(nx).append(ny).toString());
            sb = new StringBuilder();
            set.add(sb.append(nx).append(ny).append(x).append(y).toString());
            
            x = nx;
            y = ny;
        }
        
        return set.size() / 2;
    }
}