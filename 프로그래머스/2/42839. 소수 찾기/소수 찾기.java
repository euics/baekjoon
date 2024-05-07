import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Long> permutation = new HashSet<>();
        permutation("", numbers, permutation);
        
        return (int)permutation.stream().filter(this::isPrime).count();
    }
    
    public void permutation(String prefix, String str, Set<Long> permutation) {
        if(!prefix.equals("")) permutation.add(Long.parseLong(prefix));
        
        int n = str.length();
        for(int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), permutation);
        }
    }
    
    public boolean isPrime(long num) {
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        
        for(int i = 3; i * i <= num; i += 2) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}