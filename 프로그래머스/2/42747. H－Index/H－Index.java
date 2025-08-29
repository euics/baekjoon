import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        int h = arr[0], maxH = Integer.MIN_VALUE;
        while (h >= 0) {
            int cnt = 0;
            for (int citation : citations) if (citation >= h) cnt++;

            if (cnt >= h) {
                maxH = h;
                break;
            }

            h--;
        }

        return maxH;
    }
}