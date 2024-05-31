class Solution {
	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		String convert = convert(n, m, t);

		int cnt = 0, pointer = 0;
		while (cnt < t) {
			if(pointer % m + 1 == p) {
				sb.append(convert.charAt(pointer));
				cnt++;
			}

			pointer++;
		}

		return sb.toString();
	}

	public String convert(int n, int m, int t) {
		int num = 1;
		StringBuilder convert = new StringBuilder();
		convert.append(0);

		while (convert.toString().length() <= m * t) {
			StringBuilder sb = new StringBuilder();
			int tmp = num;

			while (tmp > 0) {
				int remain = tmp % n;
				if (remain >= 10) {
					switch (remain) {
						case 10:
							sb.insert(0, 'A');
							break;
						case 11:
							sb.insert(0, 'B');
							break;
						case 12:
							sb.insert(0, 'C');
							break;
						case 13:
							sb.insert(0, 'D');
							break;
						case 14:
							sb.insert(0, 'E');
							break;
						case 15:
							sb.insert(0,
								'F');
							break;
					}
				} else {
					sb.insert(0, remain);
				}

				tmp /= n;
			}

			convert.append(sb);
			num++;
		}

		return convert.toString();
	}
}