import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int solution(String[][] book_time) {
		int[][] bookTimeIntegerFormat = new int[book_time.length][2];
		for (int i = 0; i < book_time.length; i++)
			bookTimeIntegerFormat[i] = changeTimeFormat(book_time[i]);
		Arrays.sort(bookTimeIntegerFormat, (a, b) -> a[0] - b[0]);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < bookTimeIntegerFormat.length; i++) {
			if (!pq.isEmpty() && pq.peek()[1] + 10 <= bookTimeIntegerFormat[i][0])
				pq.poll();

			pq.add(bookTimeIntegerFormat[i]);
			max = Math.max(max, pq.size());
		}

		return max;
	}

	public int[] changeTimeFormat(String[] bookTime) {
		return new int[] {
			Integer.parseInt(bookTime[0].split(":")[0]) * 60 + Integer.parseInt(bookTime[0].split(":")[1]),
			Integer.parseInt(bookTime[1].split(":")[0]) * 60 + Integer.parseInt(bookTime[1].split(":")[1]),
		};
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		T.solution(new String[][] {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"},
			{"18:20", "21:20"}});
	}
}