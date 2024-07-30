import java.util.*;

class Solution {
	public int[] solution(String[] operations) {
		List<Integer> list = new ArrayList<>();
		for (String operation : operations) {
			char order = operation.split(" ")[0].charAt(0);
			int num = Integer.parseInt(operation.split(" ")[1]);

			if (order == 'I')
				list.add(num);
			else {
				if (list.isEmpty())
					continue;

				if (num == 1)
					list.remove(list.size() - 1);
				else
					list.remove(0);
			}

			Collections.sort(list);
		}

		if (list.isEmpty())
			return new int[] {0, 0};
		else
			return new int[] {list.get(list.size() - 1), list.get(0)};
	}
}