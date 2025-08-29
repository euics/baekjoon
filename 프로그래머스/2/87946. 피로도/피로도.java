import java.util.*;

class Solution {
    static int n, ans = Integer.MIN_VALUE;

    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        permutation(k, dungeons, 0, new int[n], new boolean[n]);

        return ans;
    }

    public void permutation(int k, int[][] dungeons, int L, int[] permutation, boolean[] bool) {
        if (L == n) {
//            for (int x : permutation) System.out.printf("%d ", x);
//            System.out.println();
            ans = Math.max(ans, move(k, dungeons, permutation));

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!bool[i]) {
                bool[i] = true;
                permutation[L] = i;
                permutation(k, dungeons, L + 1, permutation, bool);
                bool[i] = false;
            }
        }
    }

    public int move(int k, int[][] dungeons, int[] permutation) {
        int cnt = 0, remain = k;

        for (int i = 0; i < n; i++) {
            int min = dungeons[permutation[i]][0];
            int remove = dungeons[permutation[i]][1];

            if (remain >= min) {
                remain -= remove;
                cnt++;
            } else {
                break;
            }
        }

        return cnt;
    }
}