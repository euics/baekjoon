import java.util.*;

class Solution {
	public int[] solution(String[] operations) {
		LinkedList<Integer> list = new LinkedList<>();

		for (String operation : operations) {
			String[] split = operation.split(" ");
			int num = Integer.parseInt(split[1]);

			if (split[0].equals("I")) {
				list.add(num);

				Collections.sort(list);
			} else {
				if (list.isEmpty()) {
					continue;
				}

				switch (num) {
					case 1 -> list.pollLast();
					case -1 -> list.pollFirst();
				}
			}
		}

		return list.isEmpty() ? new int[] {0, 0} : new int[] {list.getLast(), list.getFirst()};
	}
}