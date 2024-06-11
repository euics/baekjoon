import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public String[] solution(String[] files) {
		Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] file1 = splitFile(o1);
				String[] file2 = splitFile(o2);

				int headCompare = file1[0].compareToIgnoreCase(file2[0]);
				if (headCompare == 0) {
					int number1 = Integer.parseInt(file1[1]);
					int number2 = Integer.parseInt(file2[1]);

					return Integer.compare(number1, number2);
				}

				return headCompare;
			}

			private String[] splitFile(String file) {
				String head = file.split("[0-9]")[0];
				String number = file.replaceAll("[^0-9]", " ").trim().split(" ")[0];

				return new String[] {head, number};
			}
		});
		
		return files;
	}
}