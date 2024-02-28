import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        Set<Integer> permutation = new HashSet<>();
        permutation("", numbers, permutation);

        int answer = 0;
        for(int per : permutation) {
            if(findPrime(per)) answer++;
        }

        return answer;
    }

    private void permutation(String prefix, String str, Set<Integer> permutation) {
        if(!prefix.equals("")) permutation.add(Integer.parseInt(prefix));

        int n = str.length();

        for(int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), permutation);
        }
    }

    private boolean findPrime(int num) {
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        for(int i = 3; i * i <= num; i += 2) {
            if(num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("011"));
    }
}