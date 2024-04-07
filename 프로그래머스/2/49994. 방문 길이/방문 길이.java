import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        
        int x = 0, y = 0;
        for (char dir : dirs.toCharArray()) {
            int nx = x, ny = y;

            if(dir == 'U' && y + 1 <= 5) ny++;
            else if(dir == 'D' && y - 1 >= -5) ny--;
            else if(dir == 'L' && x - 1 >= -5) nx--;
            else if(dir == 'R' && x + 1 <= 5) nx++;

            if(nx == x && ny == y) continue;
            
            set.add("" + x + y + nx + ny);
            set.add("" + nx + ny + x + y);
            
            x = nx;
            y = ny;
        }

        return set.size() / 2;
    }
}