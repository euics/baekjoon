import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dix = {0, 0, -1, 1};
        int[] diy = {-1, 1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        int L = 1;

        while (!q.isEmpty()) {
            int length = q.size();

            for (int i = 0; i < length; i++) {
                int[] cur = q.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) return L;

                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dix[d];
                    int ny = cur[1] + diy[d];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && maps[ny][nx] == 1) {
                        if (!visited[ny][nx]) {
                            visited[ny][nx] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }

            L++;
        }

        return -1;
    }
}