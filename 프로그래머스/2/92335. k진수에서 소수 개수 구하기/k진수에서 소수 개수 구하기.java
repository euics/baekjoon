class Solution {
    public int solution(int n, int k) {
        String num = changeNum(n, k);
        String[] nums = num.split("0");

        int answer = 0;
        for(String tmp : nums) {
            if(!tmp.equals("") && isPrime(Long.parseLong(tmp))) answer++;
        }
        
        return answer;
    }

    public String changeNum(int n, int k){
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            sb.insert(0, n % k);
            n /= k;
        }

        return sb.toString();
    }

    public boolean isPrime(Long num){
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        for(long i = 3; i * i <= num; i += 2){
            if(num % i == 0) return false;
        }

        return true;
    }
}