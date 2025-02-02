class Solution {
    static int cnt = 0, loop = 0;
    
    public int[] solution(String s) {
        
        while(!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    cnt++;
                } else {
                    sb.append("1");
                }
            }
            
            s = Integer.toString(sb.toString().length(), 2);
            loop++;
        }
        
        return new int[]{loop, cnt};
    }
}