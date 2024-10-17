import java.util.*;
import java.io.*;

public class Main {
	static int answer = 0;
	static PriorityQueue<int[]> conferenceRoom
		= new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			conferenceRoom.add(new int[] {start, end});
		}

		int endTime = 0;
		while (!conferenceRoom.isEmpty()) {
			int[] curRoom = conferenceRoom.poll();

			if (curRoom[0] >= endTime) {
				endTime = curRoom[1];
				answer++;
			}
		}

		System.out.println(answer);
	}
}