import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(String dirs) {
		Set<String> route = new HashSet<>();
		int x = 0, y = 0;

		for(char dir : dirs.toCharArray()) {
			int nx = x, ny = y;

			if(dir == 'U' && y + 1 <= 5) ny++;
			if(dir == 'D' && y - 1 >= -5) ny--;
			if(dir == 'L' && x - 1 >= -5) nx--;
			if(dir == 'R' && x + 1 <= 5) nx++;
			
			if(nx == x && ny == y) continue;
			
			route.add("" + x + y + nx + ny);
			route.add("" + nx + ny + x + y);
			
			x = nx;
			y = ny;
		}
		
		return route.size() / 2;
	}
}