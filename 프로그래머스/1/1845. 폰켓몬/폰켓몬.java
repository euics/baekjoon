import java.util.*;

class Solution {
	static Set<Integer> set = new HashSet<>();

	public int solution(int[] nums) {
		int type = nums.length / 2;
		for (int num : nums) {
			set.add(num);
		}

		return Math.min(set.size(), type);
	}
}