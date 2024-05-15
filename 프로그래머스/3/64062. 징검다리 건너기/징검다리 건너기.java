class Solution {
    public int solution(int[] stones, int k) {
        int low = 0, high = 0;
        for(int stone : stones) high = Math.max(high, stone);

        int answer = 0;
        while(low <= high) {
            int mid = (low + high) / 2;

            if(canCross(stones, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    public boolean canCross(int[] stones, int k, int mid) {
        int cnt = 0;
        for(int stone : stones) {
            if(stone - mid < 0) {
                cnt++;

                if(cnt >= k) return false;
            } else {
                cnt = 0;
            }
        }

        return true;
    }
}