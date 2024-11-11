import java.util.*;

class Solution {
	static ArrayList<Integer> list = new ArrayList<>();

	public int[] solution(String[] operations) {
		for (String operation : operations) {
			String[] split = operation.split(" ");
			char order = split[0].charAt(0);
			int num = Integer.parseInt(split[1]);

			if (order == 'I') {
				list.add(num);
			} else {
				if(list.isEmpty()) continue;

				if(num == -1) {
					list.remove(0);
				} else {
					list.remove(list.size() - 1);
				}
			}
			
			Collections.sort(list);
		}


		if (list.isEmpty()) {
			return new int[] {0, 0};
		} else {
			return new int[] {list.get(list.size() - 1), list.get(0)};
		}
	}
}