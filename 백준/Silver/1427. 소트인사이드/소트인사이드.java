import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		String s = br.readLine();
		char[] ch = s.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			int index = i;
			for (int j = i + 1; j < ch.length; j++) {
				if (Character.getNumericValue(ch[j]) > Character.getNumericValue(ch[index]))
					index = j;
			}

			char tmp = ch[index];
			ch[index] = ch[i];
			ch[i] = tmp;
		}

		for (char x : ch)
			System.out.printf("%c", x);
	}
}