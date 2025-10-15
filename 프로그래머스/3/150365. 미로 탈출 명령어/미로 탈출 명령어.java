import java.util.*;

class Solution {
    static String ans = "impossible";
    static int[] dix = {0, -1, 1, 0};
    static int[] diy = {1, 0, 0, -1};
    static char[] ch = {'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[] des = new int[]{c - 1, r - 1};

        int manhattan = Math.abs(y - r) + Math.abs(x - c);
        if (k < manhattan || (k - manhattan) % 2 != 0) return "impossible";

        DFS(n, m, k, y - 1, x - 1, des, "");

        return ans;
    }

    public void DFS(int n, int m, int k, int x, int y, int[] des, String route) {
        if (!ans.equals("impossible")) return;

        int remain = k - route.length();
        int manhattan = Math.abs(x - des[0]) + Math.abs(y - des[1]);
        if (remain < manhattan || (remain - manhattan) % 2 != 0) return;

        if (route.length() == k) {
            if (x == des[0] && y == des[1]) {
                ans = route;
            }

            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dix[d];
            int ny = y + diy[d];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                DFS(n, m, k, nx, ny, des, route + ch[d]);
            }
        }
    }
}