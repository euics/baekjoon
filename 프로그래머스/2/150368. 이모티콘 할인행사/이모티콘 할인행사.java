import java.util.*;

class Solution {
    static int[] ans = new int[2];
    static double[] discounts = new double[]{0.1, 0.2, 0.3, 0.4};
    static double[] permutation;

    public int[] solution(int[][] users, int[] emoticons) {
        permutation = new double[emoticons.length];
        permutation(0, emoticons.length, users, emoticons);

        return ans;
    }

    public void permutation(int L, int depth, int[][] users, int[] emoticons) {
        if (L == depth) {
            double[] tmp = new double[emoticons.length];
            for (int i = 0; i < tmp.length; i++) tmp[i] = (1 - permutation[i]) * emoticons[i];

            int plus = 0;
            double sell = 0;
            for (int i = 0; i < users.length; i++) {
                double sum = 0;

                for (int j = 0; j < tmp.length; j++) {
                    if (permutation[j] >= (double) users[i][0] / 100) {
                        sum += tmp[j];
                    }
                }

                if (sum >= users[i][1]) {
                    plus++;
                    continue;
                }

                sell += sum;
            }

            if (ans[0] < plus) {
                ans[0] = plus;
                ans[1] = (int) sell;
            } else if (ans[0] == plus) {
                if (ans[1] <= sell) {
                    ans[0] = plus;
                    ans[1] = (int) sell;
                }
            }

            return;
        }

        for (int i = 0; i < discounts.length; i++) {
            permutation[L] = discounts[i];
            permutation(L + 1, depth, users, emoticons);
        }
    }
}