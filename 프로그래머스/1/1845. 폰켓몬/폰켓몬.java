import java.util.*;
import java.util.stream.*;

class Solution {
	public int solution(int[] nums) {
		int n = nums.length;
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

		return Math.min(set.size(), n / 2);
	}
}