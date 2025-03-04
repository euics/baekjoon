import java.util.*;

class Solution {
	public int[] solution(String[] operations) {
		LinkedList<Integer> list = new LinkedList<>();

		for (String operation : operations) {
			String[] split = operation.split(" ");
			int num = Integer.parseInt(split[1]);

			if (split[0].equals("I")) {
				list.add(num);
			} else {

				if (list.isEmpty()) {
					continue;
				}

				if (num == 1) {
					list.pollLast();
				} else {
					list.pollFirst();
				}
			}

			Collections.sort(list);
		}

		if (list.isEmpty()) {
			return new int[] {0, 0};
		} else {
			return new int[] {list.getLast(), list.getFirst()};
		}
	}
}