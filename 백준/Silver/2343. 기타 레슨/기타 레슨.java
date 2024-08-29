import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] lectures = new int[N];
		st = new StringTokenizer(br.readLine());
		int min = Integer.MIN_VALUE, max = 0;
		for (int i = 0; i < N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			min = Math.max(min, lectures[i]);
			max += lectures[i];
		}

		int answer = 0;
		while (min <= max) {
			int mid = (min + max) / 2;

			if (canDivide(lectures, M, mid)) {
				answer = mid;
				max = mid - 1;
			} else
				min = mid + 1;
		}

		System.out.println(answer);
	}

	public static boolean canDivide(int[] lectures, int M, int mid) {
		int sum = 0, cnt = 1;
		for (int lecture : lectures) {
			if (sum + lecture > mid) {
				cnt++;
				sum = 0;
			}

			sum += lecture;

			if (cnt > M)
				return false;
		}

		return true;
	}
}