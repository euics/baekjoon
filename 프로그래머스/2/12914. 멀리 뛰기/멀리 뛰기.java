import java.util.*;

class Solution {
    static long[] memo;

    public long solution(int n) {
        memo = new long[n + 1];
        Arrays.fill(memo, -1);

        return fibo(n);
    }

    public long fibo(int L) {
        if (L <= 1) return 1;
        if (memo[L] != -1) return memo[L];
        return memo[L] = (fibo(L - 1) + fibo(L - 2)) % 1234567;
    }
}