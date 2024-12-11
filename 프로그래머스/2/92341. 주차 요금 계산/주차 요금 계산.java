import java.util.*;

class Solution {
	static ArrayList<Integer> answer = new ArrayList<>();
	static HashMap<Integer, Integer> inMap = new HashMap<>();
	static TreeMap<Integer, Integer> recordMap = new TreeMap<>();

	public int[] solution(int[] fees, String[] records) {
		for (String record : records) {
			String[] tmp = record.split(" ");
			int carNum = Integer.parseInt(tmp[1]);
			int time = convert(tmp[0]);

			switch (tmp[2]) {
				case "IN":
					inMap.put(carNum, time);
					break;
				case "OUT":
					recordMap.put(carNum, recordMap.getOrDefault(carNum, 0) + time - inMap.get(carNum));
					inMap.remove(carNum);
					break;
			}
		}

		for (int carNum : inMap.keySet()) {
			int time = convert("23:59");
			recordMap.put(carNum, recordMap.getOrDefault(carNum, 0) + time - inMap.get(carNum));
		}

		for (int carNum : recordMap.keySet()) {
			answer.add(calculate(fees, recordMap.get(carNum)));
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	public int convert(String time) {
		return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
	}

	public int calculate(int[] fees, int time) {
		if (time <= fees[0]) {
			return fees[1];
		} else {
			double fee = (Math.ceil((double)(time - fees[0]) / fees[2])) * fees[3];

			return (int)(fees[1] + fee);
		}
	}
}