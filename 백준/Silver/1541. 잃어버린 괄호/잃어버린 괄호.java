import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		String input = br.readLine();
		String[] splitByMinus = input.split("-");

		int sum = Integer.MAX_VALUE;
		for (String value : splitByMinus) {
			int tmp = 0;

			String[] splitByPlus = value.split("\\+");
			for (String plus : splitByPlus)
				tmp += Integer.parseInt(plus);

			if (sum == Integer.MAX_VALUE)
				sum = tmp;
			else
				sum -= tmp;
		}

		System.out.println(sum);
	}
}