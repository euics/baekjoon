import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> info = new HashMap<>();
        for (int i = 0; i < participant.length; i++) info.put(participant[i], info.getOrDefault(participant[i], 0) + 1);

        for(int i = 0; i < completion.length; i++) {
            if(info.containsKey(completion[i])) {
                info.put(completion[i], info.get(completion[i]) - 1);

                if(info.get(completion[i]) == 0) info.remove(completion[i]);
            }
        }

        String answer = "";
        for(String keySet : info.keySet()) answer = keySet;

        return answer;
    }
}