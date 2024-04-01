import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static Map<String, Integer> dictionary;
    List<Integer> answer = new ArrayList<>();

    public int[] solution(String msg) {
        initDictionary();

        int idx = 0;
        while(idx < msg.length()) {
            StringBuilder sb = new StringBuilder();

            while(idx < msg.length()) {
                if(!dictionary.containsKey(sb.toString() + msg.charAt(idx))) break;
                else sb.append(msg.charAt(idx));

                idx++;
            }

            answer.add(dictionary.get(sb.toString()));
            if(idx < msg.length()) dictionary.put(sb.toString() + msg.charAt(idx), dictionary.size() + 1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public void initDictionary() {
        dictionary = new HashMap<>();

        for (int i = 0; i < 26; i++) dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
    }
}