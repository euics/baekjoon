import java.util.*;

class Solution {
    static int ans = Integer.MIN_VALUE, cnt = 0;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    public int solution(int[][] land) {
        boolean[][] bool = new boolean[land.length][land[0].length];

        for (int i = 0, idx = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (!bool[i][j] && land[i][j] == 1) {
                    cnt = 0;
                    DFS(land, idx, j, i, bool);

                    map.put(idx, cnt);
                    idx++;
                }
            }
        }

        for (int col = 0; col < land[0].length; col++) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;

            for (int row = 0; row < land.length; row++) {
                if (land[row][col] != 0 && !set.contains(land[row][col])) {
                    sum += map.get(land[row][col]);
                    set.add(land[row][col]);
                }
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public void DFS(int[][] land, int idx, int x, int y, boolean[][] bool) {
        land[y][x] = idx;
        bool[y][x] = true;
        cnt++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dix[d];
            int ny = y + diy[d];

            if (nx >= 0 && ny >= 0 && ny < land.length && nx < land[ny].length && land[ny][nx] == 1) {
                if (!bool[ny][nx]) {
                    land[ny][nx] = idx;
                    bool[ny][nx] = true;
                    DFS(land, idx, nx, ny, bool);
                }
            }
        }
    }
}