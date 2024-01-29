import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++)
            map.put(String.valueOf((char) ('A' + i)), i + 1);

        int idx = 0;
        while(idx < msg.length()){
            StringBuilder sb = new StringBuilder();

            while(idx < msg.length()){
                if(!map.containsKey(sb.toString() + msg.charAt(idx))) break;
                else sb.append(msg.charAt(idx));

                idx++;
            }

            answer.add(map.get(sb.toString()));

            if(idx < msg.length()) map.put(sb.toString() + msg.charAt(idx), map.size() + 1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}