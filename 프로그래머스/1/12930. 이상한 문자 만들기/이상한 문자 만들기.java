class Solution {
    static StringBuilder sb = new StringBuilder();
    
    public String solution(String s) {
        
        for(int i = 0, cnt = 0; i < s.length(); i++) {
            
            if(s.charAt(i) == ' ') {
                sb.append(" ");
                cnt = 0;
                continue;
            }
            
            if(cnt % 2 == 0) {
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
            
            cnt++;
        }
        
        return sb.toString();
    }
}