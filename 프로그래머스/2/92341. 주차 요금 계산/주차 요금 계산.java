import java.util.*;

class Solution {
    static List<Integer> ans = new ArrayList<>();

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingLot = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();
        Map<String, Integer> fee = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");

            if (split[2].equals("IN")) {
                parkingLot.put(split[1], time(split[0]));
            } else {
                int in = parkingLot.get(split[1]);
                int out = time(split[0]);
                int time = out - in;

                times.put(split[1], times.getOrDefault(split[1], 0) + time);
                parkingLot.remove(split[1]);
            }
        }

        for (String car : parkingLot.keySet()) {
            int in = parkingLot.get(car);
            int out = time("23:59");
            int time = out - in;

            times.put(car, times.getOrDefault(car, 0) + time);
        }

        for (String car : times.keySet()) {
            int calculate = calculate(fees[0], fees[1], fees[2], fees[3], times.get(car));
            fee.put(car, calculate);
        }

        List<String> cars = new LinkedList<>(fee.keySet());
        Collections.sort(cars);
        for (String car : cars) ans.add(fee.get(car));

        return ans.stream().mapToInt(i -> i).toArray();
    }

    public int time(String time) {
        int hour = Integer.parseInt(time.split(":")[0]) * 60;
        int min = Integer.parseInt(time.split(":")[1]);

        return hour + min;
    }

    public int calculate(int basic, int fee, int per, int overFee, int time) {
        if (time <= basic) return fee;

        return (time - basic) % per == 0 ? fee + ((time - basic) / per) * overFee : fee + ((time - basic) / per + 1) * overFee;
    }
}