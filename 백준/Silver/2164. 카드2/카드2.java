import java.util.*;
import java.io.*;

public class Main {
	static Deque<Integer> dq = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			dq.addLast(i);
		}

		while (!dq.isEmpty() && dq.size() != 1) {
			dq.pollFirst();
			dq.addLast(dq.pollFirst());
		}

		System.out.println(dq.pollFirst());
	}
}