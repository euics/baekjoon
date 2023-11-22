class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left = 1;
        long right = (long)n * getMax(times);
        
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            
            for(int time : times){
                sum += mid / time;
            }
            
            if(sum >= n){
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public long getMax(int[] times){
        long max = 0;
        for(int time : times){
            max = Math.max(max, time);
        }
        
        return max;
    }
}