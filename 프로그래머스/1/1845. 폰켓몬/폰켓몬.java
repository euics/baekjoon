import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        
        return set.size() <= n / 2 ? set.size() : n / 2;
    }
}