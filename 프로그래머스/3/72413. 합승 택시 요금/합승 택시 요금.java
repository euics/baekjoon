import java.util.*;

class Solution {
    static int ans = Integer.MAX_VALUE;
    static int[][] dis;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        dis = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
            dis[i][i] = 0;
        }
        for (int i = 0; i < fares.length; i++) {
            dis[fares[i][0]][fares[i][1]] = Math.min(dis[fares[i][0]][fares[i][1]], fares[i][2]);
            dis[fares[i][1]][fares[i][0]] = Math.min(dis[fares[i][1]][fares[i][0]], fares[i][2]);
        }

        for (int K = 1; K <= n; K++) {
            for (int S = 1; S <= n; S++) {
                for (int E = 1; E <= n; E++) {
                    if (dis[S][E] > dis[S][K] + dis[K][E]) {
                        dis[S][E] = dis[S][K] + dis[K][E];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            if (dis[s][i] == Integer.MAX_VALUE / 2) continue;
            if (dis[i][a] == Integer.MAX_VALUE / 2) continue;
            if (dis[i][b] == Integer.MAX_VALUE / 2) continue;

            int sum = 0;
            sum += (dis[s][i] + dis[i][a] + dis[i][b]);
            ans = Math.min(ans, sum);
        }

        ans = Math.min(ans, dis[s][a] + dis[s][b]);

        return ans;
    }
}