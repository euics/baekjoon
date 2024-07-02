import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		List<int[]> arr = new ArrayList<>();
		for (int i = 0; i < N; i++)
			arr.add(new int[] {i, Integer.parseInt(br.readLine())});

		Collections.sort(arr, (a, b) -> a[1] - b[1]);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.size(); i++)
			max = Math.max(max, arr.get(i)[0] - i);

		System.out.println(max + 1);
	}
}