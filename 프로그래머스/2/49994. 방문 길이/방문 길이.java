import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        
        int x = 0, y = 0;
        for(char dir : dirs.toCharArray()) {
            int prevX = x, prevY = y;
            
            if(dir == 'U' && y + 1 <= 5) prevY++;
            if(dir == 'D' && y - 1 >= -5) prevY--;
            if(dir == 'R' && x + 1 <= 5) prevX++;
            if(dir == 'L' && x - 1 >= -5) prevX--;
            
            if(prevX == x && prevY == y) continue;
            
            set.add("" + x + y + prevX + prevY);
            set.add("" + prevX + prevY + x + y);
            
            x = prevX;
            y = prevY;
        }
        
        return set.size() / 2;
    }
}