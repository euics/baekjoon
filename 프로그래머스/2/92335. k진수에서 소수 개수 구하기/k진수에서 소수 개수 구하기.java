import java.util.*;

class Solution {
    public int solution(int n, int k) {
                int answer = 0;
        String num = Integer.toString(n, k);

        int start = 0;
        int index = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for (char x : num.toCharArray()) {
            if (x == '0') {
                list.add(index);
            }
            index++;
        }
        
        ArrayList<Long> Number = new ArrayList<>();
        list.add(num.length());
        String a = "";
        int j = 0;

        for(int end : list){
            String q = num.substring(start, end).trim();
            if(!q.isEmpty() && q.matches("\\d+")){
                Number.add(Long.parseLong(q));
            }
            start = end + 1;
        }

        return answer = PrimeNumber(Number);

    }
    
    public int PrimeNumber(ArrayList <Long> list){
        int cnt = 0;
        for(long x : list){
            if(isPrime(x)){
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isPrime(long n){
        if(n<=1){
            return false;
        }
        for(long i = 2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}