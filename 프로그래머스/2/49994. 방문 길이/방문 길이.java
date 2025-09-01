import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0, y = 0, length = 0;
        List<String> list = new ArrayList<>();

        for (char dir : dirs.toCharArray()) {
            int nx = x, ny = y;

            if (dir == 'U') ny++;
            else if (dir == 'D') ny--;
            else if (dir == 'L') nx--;
            else nx++;

            if (nx >= -5 && ny >= -5 && nx <= 5 && ny <= 5) {
                String coordinate1 = x + "" + y + nx + ny;
                String coordinate2 = nx + "" + ny + x + y;

                if (!list.contains(coordinate1) && !list.contains(coordinate2)) {
                    list.add(coordinate1);
                    list.add(coordinate1);

                    length++;
                }

                x = nx;
                y = ny;
            }
        }

        return length;
    }
}