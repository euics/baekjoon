import java.util.*;

class Solution {
    static List<String> ans = new ArrayList<>();

    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            if (split[0].equals("Enter") || split[0].equals("Change")) map.put(split[1], split[2]);
        }

        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");

            if (split[0].equals("Enter")) ans.add(map.get(split[1]) + "님이 들어왔습니다.");
            if (split[0].equals("Leave")) ans.add(map.get(split[1]) + "님이 나갔습니다.");
        }

        return ans.stream().toArray(String[]::new);
    }
}