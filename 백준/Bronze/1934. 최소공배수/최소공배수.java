import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(LCM(a, b)).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static int GCD(int a, int b) {
		if (b == 0)
			return a;

		return GCD(b, a % b);
	}

	public static int LCM(int a, int b) {
		return a * b / GCD(a, b);
	}
}