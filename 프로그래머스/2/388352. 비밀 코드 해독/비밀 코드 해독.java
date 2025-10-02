import java.util.*;

class Solution {
    static int result = 0;
    static int[] combi;

    public int solution(int n, int[][] q, int[] ans) {
        combi = new int[5];
        combination(0, 5, n, 1, q, ans);

        return result;
    }

    public void combination(int L, int depth, int n, int s, int[][] q, int[] ans) {
        if (L == depth) {
            if (correct(q, ans)) result++;

            return;
        }

        for (int num = s; num <= n; num++) {
            combi[L] = num;
            combination(L + 1, depth, n, num + 1, q, ans);
        }
    }

    public boolean correct(int[][] q, int[] ans) {
        for (int l = 0; l < ans.length; l++) {
            int cnt = 0;

            for (int i = 0; i < combi.length; i++) {
                for (int k = 0; k < q[l].length; k++) {
                    if (combi[i] == q[l][k]) {
                        cnt++;
                        break;
                    }
                }
            }

            if (cnt != ans[l]) return false;
        }

        return true;
    }
}