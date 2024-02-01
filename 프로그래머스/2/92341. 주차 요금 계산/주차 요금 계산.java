import java.sql.Array;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> entranceInfo = new HashMap<>();
        Map<String, Integer> totalInfo = new HashMap<>();

        for (String record : records) {
            if(record.split(" ")[2].equals("IN"))
                entranceInfo.put(record.split(" ")[1], convertTime(record.split(" ")[0]));
            else {
                int exitTime = convertTime(record.split(" ")[0]);
                String carNumber = record.split(" ")[1];
                int entranceTime = entranceInfo.get(carNumber);

                totalInfo.put(carNumber, totalInfo.getOrDefault(carNumber, 0) + exitTime - entranceTime);
                entranceInfo.remove(carNumber);
            }
        }

        Set<String> remainKeySet = entranceInfo.keySet();
        if(remainKeySet.size() != 0) {
            for(String carNumber : remainKeySet) {
                int exitTime = convertTime("23:59");
                int entranceTime = entranceInfo.get(carNumber);
                totalInfo.put(carNumber, totalInfo.getOrDefault(carNumber, 0) + exitTime - entranceTime);
            }
        }

        for(String carNumber : totalInfo.keySet()){
            int totalTime = totalInfo.get(carNumber);
            int fee = 0;
            if(totalTime > fees[0]){
                fee = fees[1] + (int) Math.ceil((double)(totalTime - fees[0]) / fees[2]) * fees[3];
            } else
                fee = fees[1];

            totalInfo.put(carNumber, fee);
        }

        for(String key : totalInfo.keySet()) System.out.printf("%s %d\n", key, totalInfo.get(key));
        
        List<String> totalInfoKey = new ArrayList<>(totalInfo.keySet());
        Collections.sort(totalInfoKey);
        
        int[] answer = new int[totalInfoKey.size()];
        int idx = 0;
        for(String sortedCarNumber : totalInfoKey) answer[idx++] = totalInfo.get(sortedCarNumber); 

        return answer;
    }

    public int convertTime(String time){
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
}