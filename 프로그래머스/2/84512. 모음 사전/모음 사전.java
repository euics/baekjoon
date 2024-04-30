import java.util.*;

class Solution {
    static Set<String> set = new HashSet<>();
    static List<String> list = new ArrayList<>();

    public int solution(String word) {
        for(int i = 1; i <= 5; i++) makeDictionary(0, i, "", "AEIOU");

        list.addAll(set);
        Collections.sort(list);

        return list.indexOf(word) + 1;
    }

    private void makeDictionary(int L, int length, String str, String vowel) {
        if(L == length) {
            set.add(str);

            return;
        }

        for(int i = 0; i < vowel.length(); i++) makeDictionary(L + 1, length, str + vowel.charAt(i), vowel);
    }
}