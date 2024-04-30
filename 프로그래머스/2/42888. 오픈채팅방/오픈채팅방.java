import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> map = new HashMap<>();
        for(String record : records) {
            if(record.split(" ")[0].equals("Leave")) continue;

            map.put(record.split(" ")[1], record.split(" ")[2]);
        }

        List<String> answer = new ArrayList<>();
        for(String record : records) {
            if(record.split(" ")[0].equals("Enter")) answer.add(map.get(record.split(" ")[1]) + "님이 들어왔습니다.");
            if(record.split(" ")[0].equals("Leave")) answer.add(map.get(record.split(" ")[1]) + "님이 나갔습니다.");
        }

        return answer.stream().toArray(String[]::new);
    }
}