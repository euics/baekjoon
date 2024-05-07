class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int x = 1; ; x++) {
            boolean bool = false;
            for(int y = 1; y <= x; y++) {
                if(x * y == brown + yellow && (x - 2) * (y - 2) == yellow) {
                    bool = true;
                    answer[0] = x;
                    answer[1] = y;
                }
            }
            
            if(bool) break;
        }
        
        return answer;
    }
}