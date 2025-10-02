import java.util.*;

class Solution {
    static int[] ans = new int[2];
    static int plusMax = 0, priceMax = 0;
    static int[] discounts = new int[]{10, 20, 30, 40};
    static int[] permutation;

    public int[] solution(int[][] users, int[] emoticons) {
        permutation = new int[emoticons.length];
        permutation(users, emoticons, 0, emoticons.length);

        return ans;
    }

    public void permutation(int[][] users, int[] emoticons, int L, int depth) {
        if (L == depth) {
            int[] results = calculate(users, emoticons);
            if (plusMax < results[0]) {
                plusMax = results[0];
                priceMax = results[1];
                ans = Arrays.copyOfRange(results, 0, results.length);
            } else if (plusMax == results[0]) {
                if (priceMax < results[1]) {
                    priceMax = results[1];
                    ans = Arrays.copyOfRange(results, 0, results.length);
                }
            }

            return;
        }

        for (int i = 0; i < discounts.length; i++) {
            permutation[L] = discounts[i];
            permutation(users, emoticons, L + 1, depth);
        }
    }

    public int[] calculate(int[][] users, int[] emoticons) {
        int plus = 0, price = 0;
        int[] results = new int[users.length];
        for (int i = 0; i < users.length; i++) {
            int sum = 0;

            for (int j = 0; j < emoticons.length; j++) {
                if (permutation[j] >= users[i][0]) {
                    sum += emoticons[j] * (100 - permutation[j]) / 100;
                }
            }

            results[i] = sum;
        }

        for (int i = 0; i < users.length; i++) {
            if (results[i] >= users[i][1]) plus++;
            else price += results[i];
        }

        return new int[]{plus, price};
    }
}