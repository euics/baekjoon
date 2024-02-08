class Solution {

    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};

        int share = s / n;
        int remain = s % n;
        
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) answer[i] = share;
        
        for(int i = n - 1; i >= n - remain; i--) answer[i]++;
        
        return answer;
    }
}