import java.util.*;

class Solution {
    public int solution(String word) {
        for(int length = 1; length <= 5; length++) setDictionary(0, length, word, "AEIOU", "");

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        return list.indexOf(word) + 1;
    }

    static Set<String> set = new HashSet<>();

    private void setDictionary(int L, int length, String word, String vowel, String str) {
        if(L == length) {
            set.add(str);

            return;
        }

        for(int i = 0; i < vowel.length(); i++) setDictionary(L + 1, length, word, vowel, str + vowel.charAt(i));
    }
}