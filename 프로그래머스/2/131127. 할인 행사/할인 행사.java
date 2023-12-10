import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = want.length;
        int m = discount.length;

        for(int i = 0; i <= m - 10; i++){
            Map<String, Integer> discountInfo = new HashMap<>();
            int cnt = 0, index = i;
            while(index < m && cnt < 10) {
                discountInfo.put(discount[index], discountInfo.getOrDefault(discount[index], 0) + 1);
                index++;
                cnt++;
            }

            boolean bool = true;
            for(int j = 0; j < n; j++) {
                if(!discountInfo.containsKey(want[j]) || discountInfo.get(want[j]) < number[j]) {
                    bool = false;
                    break;
                }
            }

            if(bool) answer++;
        }

        return answer;
    }
}