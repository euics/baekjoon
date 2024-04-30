import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> map = new HashMap<>();
        for(String participant : participants) map.put(participant, map.getOrDefault(participant, 0) + 1);

        for(String completion : completions) {
            map.put(completion, map.get(completion) - 1);

            if(map.get(completion) == 0) map.remove(completion);
        }

        List<String> answer = new LinkedList<>(map.keySet());
        return answer.get(0);
    }
}