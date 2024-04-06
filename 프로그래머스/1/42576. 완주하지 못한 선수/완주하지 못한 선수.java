import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = initMap(participant);
        countCompletion(map, completion);

        return new ArrayList<>(map.keySet()).get(0);
    }

    public Map<String, Integer> initMap(String[] participants) {
        Map<String, Integer> map = new HashMap<>();
        for(String participant : participants) map.put(participant, map.getOrDefault(participant, 0) + 1);

        return map;
    }

    public void countCompletion(Map<String, Integer> map, String[] completions) {
        for(String completion : completions) {
            if(map.containsKey(completion)) map.put(completion, map.get(completion) - 1);
            if(map.get(completion) == 0) map.remove(completion);
        }
    }
}