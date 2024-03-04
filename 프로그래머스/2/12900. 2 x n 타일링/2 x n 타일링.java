class Solution {
    public int solution(int n) {
        int MOD = 1_000_000_007;

        int[] fibo = new int[n + 1];
        fibo[1] = 1;
        fibo[2] = 2;

        for(int i = 3; i <= n; i++) fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;

        return fibo[n];
    }
}