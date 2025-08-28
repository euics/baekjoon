import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int size = 1; size <= elements.length; size++) {
                sum += elements[(i + size - 1) % elements.length];
                set.add(sum);
            }
        }

        return set.size();
    }
}