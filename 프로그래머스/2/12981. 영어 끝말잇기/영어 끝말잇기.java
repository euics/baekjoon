import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i = 1; i < words.length; i++){
            
            String prevWord = words[i - 1];
            String curWord = words[i];
            
            if(!set.contains(words[i]) && prevWord.charAt(prevWord.length() - 1) == curWord.charAt(0)){
                set.add(curWord);
            }
            else {
                return new int[]{i % n + 1 , i / n + 1};
            }
        }

        return answer;
    }
}