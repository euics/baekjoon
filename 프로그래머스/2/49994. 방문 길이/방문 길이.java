import java.util.*;

class Solution {
	static int answer = 0;
	static Set<String> set = new HashSet<>();

	public int solution(String dirs) {
		int x = 0, y = 0;

		for (char dir : dirs.toCharArray()) {
			int tmpX = x, tmpY = y;

			switch (dir) {
				case 'U':
					y++;
					break;
				case 'D':
					y--;
					break;
				case 'R':
					x++;
					break;
				case 'L':
					x--;
			}

			if (x < -5 || y < -5 || x > 5 || y > 5) {
				x = tmpX;
				y = tmpY;
				continue;
			}

			StringBuilder sb1 = new StringBuilder();
			sb1.append(tmpX).append(tmpY).append(x).append(y);
			StringBuilder sb2 = new StringBuilder();
			sb2.append(x).append(y).append(tmpX).append(tmpY);

			if (set.contains(sb1.toString()) || set.contains(sb2.toString())) {
				continue;
			} else {
				set.add(sb1.toString());
				set.add(sb2.toString());
				answer++;
			}
		}

		return answer;
	}
}