import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> permutation = new HashSet<>();
        permutation("", numbers, permutation);
        
        return (int)permutation.stream().filter(this::isPrime).count();
    }
    
    private void permutation(String prefix, String str, Set<Integer> permutation){
        int n = str.length();
        
        if(!prefix.equals("")){
            permutation.add(Integer.parseInt(prefix));
        }
        
        for(int i = 0; i < n; i++){
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), permutation);
        }
    }
    
    private boolean isPrime(int number){
        if(number <= 1)
            return false;
        if(number <= 3)
            return true;
        if(number % 2 == 0 || number % 3 == 0)
            return false;
        for(int i = 5; i * i <= number; i += 6){
            if(number % i == 0 || number % (i + 2) == 0){
                return false;
            }
        }
        
        return true;
    }
}