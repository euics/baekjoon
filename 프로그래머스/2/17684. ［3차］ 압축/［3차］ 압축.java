import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 26; i++) map.put(String.valueOf((char) ('A' + i)), i + 1);

        int idx = 0;
        while(idx < msg.length()){
            StringBuilder w = new StringBuilder();

            while(idx < msg.length()){
                if(!map.containsKey(w.toString() + msg.charAt(idx))) break;
                else w.append(msg.charAt(idx));

                idx++;
            }

            answer.add(map.get(w.toString()));

            if(idx < msg.length()) map.put(w.append(msg.charAt(idx)).toString(), map.size() + 1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}