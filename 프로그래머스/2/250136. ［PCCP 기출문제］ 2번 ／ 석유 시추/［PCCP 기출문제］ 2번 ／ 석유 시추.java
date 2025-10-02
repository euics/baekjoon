import java.util.*;

class Solution {
    static int ans = Integer.MIN_VALUE, cnt, idx = 0;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    public int solution(int[][] land) {
        boolean[][] bool = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1 && !bool[i][j]) {
                    cnt = 0;
                    idx++;
                    DFS(land, j, i, bool);
                    map.put(idx, cnt);
                }
            }
        }

        for (int col = 0; col < land[0].length; col++) {
            Set<Integer> set = new HashSet<>();
            for (int row = 0; row < land.length; row++) if (land[row][col] != 0) set.add(land[row][col]);

            int sum = 0;
            for (int idx : set) sum += map.get(idx);
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public void DFS(int[][] land, int x, int y, boolean[][] bool) {
        cnt++;
        bool[y][x] = true;
        land[y][x] = idx;

        for (int d = 0; d < 4; d++) {
            int nx = x + dix[d];
            int ny = y + diy[d];

            if (nx >= 0 && ny >= 0 && nx < land[0].length && ny < land.length && land[ny][nx] == 1) {
                if (!bool[ny][nx]) {
                    bool[ny][nx] = true;
                    DFS(land, nx, ny, bool);
                }
            }
        }
    }
}