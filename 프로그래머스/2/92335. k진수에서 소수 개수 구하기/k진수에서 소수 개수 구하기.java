class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String[] nums = changeFormation(n, k).split("0");

        for (String num : nums) {
            if (!num.equals("") && isPrime(Long.parseLong(num))) answer++;
        }

        return answer;
    }

    public String changeFormation(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }

        return sb.toString();
    }

    public boolean isPrime(Long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }

}