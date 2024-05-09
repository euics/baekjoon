import java.util.*;

class Solution {
    static String vowels = "AEIOU";
    static List<String> dictionary = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        for(int length = 1; length <= 5; length++) {
            char[] permutation = new char[length];
            permutation(0, length, permutation);
        }
        
        Collections.sort(dictionary);
        return dictionary.indexOf(word) + 1;
    }
    
    public void permutation(int L, int length, char[] permutation) {
        if(L == length) {
            dictionary.add(new String(permutation));
            
            return;
        }
        
        for(int i = 0; i < vowels.length(); i++) {
            permutation[L] = vowels.charAt(i);
            permutation(L + 1, length, permutation);
        }
    }
}