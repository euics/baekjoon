import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Integer> score = new HashMap<>();

    static {
        score.put('R', 0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);
    }

    public String solution(String[] survey, int[] choices) {
        for (int i = 0; i < survey.length; i++) {
            char[] ch = survey[i].toCharArray();

            if (choices[i] >= 1 && choices[i] <= 3) score.put(ch[0], score.getOrDefault(ch[0], 0) + 4 - choices[i]);
            if (choices[i] >= 5 && choices[i] <= 7) score.put(ch[1], score.getOrDefault(ch[1], 0) + choices[i] - 4);
        }

        if (score.get('R') >= score.get('T')) sb.append("R");
        else if (score.get('R') < score.get('T')) sb.append("T");

        if (score.get('C') >= score.get('F')) sb.append("C");
        else if (score.get('C') < score.get('F')) sb.append("F");

        if (score.get('J') >= score.get('M')) sb.append("J");
        else if (score.get('J') < score.get('M')) sb.append("M");

        if (score.get('A') >= score.get('N')) sb.append("A");
        else if (score.get('A') < score.get('N')) sb.append("N");

        return sb.toString();
    }
}