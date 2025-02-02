import java.util.*;

class Solution {
    static List<String> dic = new ArrayList<>();
    static char[] permutation;
    
    public int solution(String word) {
        
        for(int length = 1; length <= 5; length++) {
            permutation = new char[length];
            
            makeDic(0, length, new char[]{'A', 'E', 'I', 'O', 'U'});
        }
        
        Collections.sort(dic);
        
        return dic.indexOf(word) + 1;
    }
    
    public void makeDic(int L, int length, char[] vowels) {
        if(L == length) {
            StringBuilder sb = new StringBuilder();
            
            for(char per : permutation) {
                sb.append(per);
            }
            
            dic.add(sb.toString());
            
            return;
        }
        
        for(int i = 0; i < vowels.length; i++) {
            permutation[L] = vowels[i];
            makeDic(L + 1, length, vowels);
        }
    }
}