import java.util.*;

class Solution {
    static int[] ans;

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> time = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");

            if (split[2].equals("IN")) {
                time.put(split[1], time(split[0]));
            } else {
                int inTime = time.get(split[1]);
                int outTime = time(split[0]);
                total.put(split[1], total.getOrDefault(split[1], 0) + outTime - inTime);
                time.remove(split[1]);
            }
        }

        int end = time("23:59");
        for (String remain : new ArrayList<>(time.keySet())) {
            int inTime = time.get(remain);
            total.put(remain, total.getOrDefault(remain, 0) + end - inTime);
        }

        List<String> cars = new ArrayList<>(total.keySet());
        Collections.sort(cars);
        ans = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int calculate = calculate(fees, total.get(cars.get(i)));
            ans[i] = calculate;
        }

        return ans;
    }

    public int time(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }

    public int calculate(int[] fees, int total) {
        if (total <= fees[0]) return fees[1];

        return fees[1] + (int) (Math.ceil((double) (total - fees[0]) / (double) fees[2])) * fees[3];
    }
}