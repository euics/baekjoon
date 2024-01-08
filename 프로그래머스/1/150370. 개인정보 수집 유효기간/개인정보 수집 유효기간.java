import java.time.format.*;
import java.time.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String term : terms){
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));

        int index = 0;
        List<Integer> answer = new ArrayList<>();

        for(String privacy : privacies){
            LocalDate collectionDate = LocalDate.parse(privacy.split(" ")[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));

            LocalDate expireDate = collectionDate.plusMonths(map.get(privacy.split(" ")[1]));
            if(expireDate.isBefore(todayDate) || expireDate.isEqual(todayDate)) answer.add(index + 1);
            index++;
        }

        Collections.sort(answer);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}