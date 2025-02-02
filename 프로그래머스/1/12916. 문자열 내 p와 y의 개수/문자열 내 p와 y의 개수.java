class Solution {
    public boolean solution(String s) {
        int cnt1 = 0, cnt2 = 0;
        
        for(char ch : s.toLowerCase().toCharArray()) {
            if(ch == 'p') {
                cnt1++;
            }
            
            if(ch == 'y') {
                cnt2++;
            }
        }

        return cnt1 == cnt2;
    }
}