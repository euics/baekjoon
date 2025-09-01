import java.util.*;

class Solution {
    static char[] ch = new char[]{'A', 'E', 'I', 'O', 'U'};
    static List<String> dictionary = new ArrayList<>();
    
    public int solution(String word) {
        for (int length = 1; length <= 5; length++) dictionary(0, length, new char[length]);
        Collections.sort(dictionary);

        return dictionary.indexOf(word) + 1;
    }

    public void dictionary(int L, int length, char[] word) {
        if (L == length) {
            StringBuilder sb = new StringBuilder();
            for (char ch : word) sb.append(ch);
            dictionary.add(sb.toString());

            return;
        }

        for (int i = 0; i < ch.length; i++) {
            word[L] = ch[i];
            dictionary(L + 1, length, word);
        }
    }
}