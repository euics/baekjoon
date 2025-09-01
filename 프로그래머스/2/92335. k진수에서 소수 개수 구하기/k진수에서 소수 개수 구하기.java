import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int ans = 0;

        String[] convert = convert(n, k).split("0");
        for (String prime : convert) if (!prime.isEmpty() && isPrime(Long.parseLong(prime))) ans++;

        return ans;
    }

    public String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remain = n % k;
            sb.insert(0, remain);
            n /= k;
        }

        return sb.toString();
    }

    public boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (long i = 3; i * i <= n; i += 2) if (n % i == 0) return false;

        return true;
    }
}