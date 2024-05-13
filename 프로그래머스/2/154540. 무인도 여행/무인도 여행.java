import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static char[][] map;
    static boolean[][] bool;

    public int[] solution(String[] maps) {
        init(maps);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(!bool[i][j] && Character.isDigit(map[i][j])) {
                    sum = Character.getNumericValue(map[i][j]);
                    DFS(j, i);
                    list.add(sum);
                }
            }
        }

        Collections.sort(list);
        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(i -> i).toArray();
    }

    public void init(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        bool = new boolean[maps.length][maps[0].length()];

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
    }

    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};
    static int sum = 0;

    public void DFS(int x, int y) {
        bool[y][x] = true;

        for(int d = 0; d < 4; d++) {
            int nx = x + dix[d];
            int ny = y + diy[d];

            if(nx >= 0 && ny >= 0 && nx < map[0].length && ny < map.length && Character.isDigit(map[ny][nx])) {
                if(!bool[ny][nx]) {
                    bool[ny][nx] = true;
                    sum += Character.getNumericValue(map[ny][nx]);
                    DFS(nx, ny);
                }
            }
        }
    }
}