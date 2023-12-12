import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> permutation = new HashSet<>();
        permutation("", numbers, permutation);

        return (int) permutation.stream().filter(this::isPrime).count();
    }

    public void permutation(String prefix, String str, Set<Integer> permutation){
        if(!prefix.equals("")) permutation.add(Integer.parseInt(prefix));

        int n = str.length();
        for(int i = 0; i < n; i++){
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), permutation);
        }
    }

    public boolean isPrime(int number){
        if(number <= 1) return false;
        if(number == 2) return true;
        if(number % 2 == 0) return false;

        for(int i = 3; i * i <= number; i += 2){
            if(number % i == 0) return false;
        }

        return true;
    }
}