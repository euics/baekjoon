import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> map = new HashMap<>();

        for(String record : records) {
            if(record.split(" ")[0].equals("Enter") || record.split(" ")[0].equals("Change")) {
                String uid = record.split(" ")[1];
                String name = record.split(" ")[2];

                map.put(uid, name);
            }
        }

        List<String> answer = new ArrayList<>();
        for(int i = 0; i < records.length; i++) {
            String uid = records[i].split(" ")[1];
            if(records[i].split(" ")[0].equals("Enter")) answer.add(map.get(uid) + "님이 들어왔습니다.");
            if(records[i].split(" ")[0].equals("Leave")) answer.add(map.get(uid) + "님이 나갔습니다.");
        }

        return answer.stream().toArray(String[]::new);
    }
}