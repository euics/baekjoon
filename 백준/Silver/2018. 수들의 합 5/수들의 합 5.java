import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int[] num = new int[n + 1];
		for (int i = 0; i <= n; i++)
			num[i] = i;

		int start = 1, end = 1, sum = 0, answer = 0;
		while (start < n + 1) {

			if (sum + num[end] < n)
				sum += num[end++];
			else if (sum + num[end] == n) {
				sum += num[end++];
				sum -= num[start++];
				answer++;
			} else
				sum -= num[start++];
		}

		System.out.println(answer);
	}
}