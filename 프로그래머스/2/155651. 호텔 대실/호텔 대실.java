import java.util.*;

class Solution {
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	static PriorityQueue<Integer> roomInfo = new PriorityQueue<>();

	public int solution(String[][] book_time) {
		for(int i = 0; i < book_time.length; i++) {
			int startTime = convertTime(book_time[i][0]);
			int endTime = convertTime(book_time[i][1]);

			pq.add(new int[]{startTime, endTime});
		}

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int startTime = cur[0], endTime = cur[1];

			if (!roomInfo.isEmpty() && roomInfo.peek() + 10 <= startTime) {
				roomInfo.poll();
			}

			roomInfo.add(endTime);
		}

		return roomInfo.size();
	}

	public int convertTime(String time) {
		return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
	}

	public static void main(String[] args) {
		String[][] timeSlots = {
			{"14:10", "19:20"},
			{"14:20", "15:20"},
			{"15:00", "17:00"},
			{"16:40", "18:20"},
			{"18:20", "21:20"}
		};

		Solution T = new Solution();
		System.out.println(T.solution(timeSlots));
	}
}